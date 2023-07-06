package com.xqing.core.injector;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class MyBatisPlusExtInjector {
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateSomeColumn extends AbstractMethod {
        private static final String MAPPER_METHOD = "updateSomeColumn";

        @Setter
        @Accessors(chain = true)
        private Predicate<TableFieldInfo> predicate;

        @Override
        public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
            SqlMethod sqlMethod = SqlMethod.UPDATE;
            String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                    sqlSet(true, true, tableInfo, true, ENTITY, ENTITY_DOT),
                    sqlWhereEntityWrapper(true, tableInfo), sqlComment());
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            return this.addUpdateMappedStatement(mapperClass, modelClass, MAPPER_METHOD, sqlSource);
        }

        private Predicate<TableFieldInfo> getPredicate() {
            return predicate;
        }

        protected String sqlSet(boolean logic, boolean ew, TableInfo table, boolean judgeAliasNull, final String alias,
                                final String prefix) {
            String sqlScript = this.getAllSqlSet(logic, prefix, table);
            if (judgeAliasNull) {
                sqlScript = SqlScriptUtils.convertIf(sqlScript, String.format("%s != null", alias), true);
            }
            if (ew) {
                sqlScript += NEWLINE;
                sqlScript += SqlScriptUtils.convertIf(SqlScriptUtils.unSafeParam(U_WRAPPER_SQL_SET),
                        String.format("%s != null and %s != null", WRAPPER, U_WRAPPER_SQL_SET), false);
            }
            sqlScript = SqlScriptUtils.convertSet(sqlScript);
            return sqlScript;
        }

        public String getAllSqlSet(boolean ignoreLogicDelFiled, final String prefix, TableInfo table) {
            final String newPrefix = prefix == null ? EMPTY : prefix;
            return table.getFieldList().stream()
                    .filter(i -> {
                        if (ignoreLogicDelFiled) {
                            return !(table.isLogicDelete() && i.isLogicDelete());
                        }
                        return true;
                    }).map(i ->
                            (getPredicate().test(i)) ? i.getSqlSet(true,newPrefix) : i.getSqlSet(newPrefix))
                    .filter(Objects::nonNull).collect(joining(NEWLINE));
        }

    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateSomeColumnById extends AbstractMethod {
        /**
         * mapper 对应的方法名
         */
        private static final String MAPPER_METHOD = "updateSomeColumnById";
        /**
         * 字段筛选条件
         */
        @Setter
        @Accessors(chain = true)
        private Predicate<TableFieldInfo> predicate;

        public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
            boolean logicDelete = tableInfo.isLogicDelete();
            SqlMethod sqlMethod = SqlMethod.UPDATE_BY_ID;
            final String additional = optlockVersion(tableInfo) + tableInfo.getLogicDeleteSql(true, false);
            String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                    sqlSet(logicDelete, false, tableInfo, false, ENTITY, ENTITY_DOT),
                    tableInfo.getKeyColumn(), ENTITY_DOT + tableInfo.getKeyProperty(), additional);
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            return addUpdateMappedStatement(mapperClass, modelClass, MAPPER_METHOD, sqlSource);
        }

        protected String sqlSet(boolean logic, boolean ew, TableInfo table, boolean judgeAliasNull, final String alias,
                                final String prefix) {
            String sqlScript = this.getAllSqlSet(logic, prefix, table);
            if (judgeAliasNull) {
                sqlScript = SqlScriptUtils.convertIf(sqlScript, String.format("%s != null", alias), true);
            }
            if (ew) {
                sqlScript += NEWLINE;
                sqlScript += SqlScriptUtils.convertIf(SqlScriptUtils.unSafeParam(U_WRAPPER_SQL_SET),
                        String.format("%s != null and %s != null", WRAPPER, U_WRAPPER_SQL_SET), false);
            }
            sqlScript = SqlScriptUtils.convertSet(sqlScript);
            return sqlScript;
        }

        public String getAllSqlSet(boolean ignoreLogicDelFiled, final String prefix, TableInfo table) {
            final String newPrefix = prefix == null ? EMPTY : prefix;
            return table.getFieldList().stream()
                    .filter(i -> {
                        if (ignoreLogicDelFiled) {
                            return !(table.isLogicDelete() && i.isLogicDelete());
                        }
                        return true;
                    }).map(i ->
                            (getPredicate().test(i)) ? i.getSqlSet(true,newPrefix) : i.getSqlSet( newPrefix))
                    .filter(Objects::nonNull).collect(joining(NEWLINE));
        }


        private Predicate<TableFieldInfo> getPredicate() {
            Predicate<TableFieldInfo> noLogic = t -> !t.isLogicDelete();
            if (predicate != null) {
                return noLogic.and(predicate);
            }
            return noLogic;
        }
    }

    public static class ListBySkipLogicMark extends AbstractMethod {
        private static final String METHOD_NAME = "listBySkipLogicMark";
        @Override
        public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
            SqlMethod sqlMethod = SqlMethod.SELECT_LIST;
            String sql = String.format(sqlMethod.getSql(),this.sqlFirst(), this.sqlSelectColumns(tableInfo, true), tableInfo.getTableName(), this.sqlWhereEntityWrapper(true, tableInfo), this.sqlComment());
            SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
            return this.addSelectMappedStatementForTable(mapperClass, METHOD_NAME, sqlSource, tableInfo);
        }

        @Override
        protected String sqlWhereEntityWrapper(boolean newLine, TableInfo table) {
            String sqlScript = table.getAllSqlWhere(false, true, "ew.entity.");
            sqlScript = SqlScriptUtils.convertIf(sqlScript, String.format("%s != null", "ew.entity"), true);
            sqlScript = sqlScript + "\n";
            sqlScript = sqlScript + SqlScriptUtils.convertIf(String.format(SqlScriptUtils.convertIf(" AND", String.format("%s and %s", "ew.nonEmptyOfEntity", "ew.nonEmptyOfNormal"), false) + " ${%s}", "ew.sqlSegment"), String.format("%s != null and %s != '' and %s", "ew.sqlSegment", "ew.sqlSegment", "ew.nonEmptyOfWhere"), true);
            sqlScript = SqlScriptUtils.convertWhere(sqlScript) + "\n";
            sqlScript = sqlScript + SqlScriptUtils.convertIf(String.format(" ${%s}", "ew.sqlSegment"), String.format("%s != null and %s != '' and %s", "ew.sqlSegment", "ew.sqlSegment", "ew.emptyOfWhere"), true);
            sqlScript = SqlScriptUtils.convertIf(sqlScript, String.format("%s != null", "ew"), true);
            return newLine ? "\n" + sqlScript : sqlScript;
        }
    }

    /**
     * replace into batch
     * 1.根据主键或者唯一索引判断表中是否已经有此行数据
     * 2.若存在，先删除此行数据，然后插入新的数据
     * 3.若没有，则直接插入新数据
     */
    public static class ReplaceIntoBatch extends AbstractMethod {
        private static final String METHOD_NAME = "replaceIntoBatch";
        @Override
        public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
            List<TableFieldInfo> fieldList = tableInfo.getFieldList();
            String columnScript = tableInfo.getKeyInsertSqlColumn(false) + fieldList.stream().map(TableFieldInfo::getInsertSqlColumn).collect(Collectors.joining(EMPTY));
            columnScript = LEFT_BRACKET + columnScript.substring(0, columnScript.length() - 1) + RIGHT_BRACKET;
            String replaceIntoValue = tableInfo.getKeyInsertSqlProperty(ENTITY_DOT,true) + fieldList.stream().map(i -> i.getInsertSqlProperty(ENTITY_DOT)).collect(Collectors.joining(EMPTY));
            replaceIntoValue = LEFT_BRACKET + replaceIntoValue.substring(0, replaceIntoValue.length() - 1) + RIGHT_BRACKET;
            String valuesScript = SqlScriptUtils.convertForeach(replaceIntoValue, "list", null, ENTITY, COMMA);
            String sql = String.format("<script>\nREPLACE INTO %s %s VALUES %s\n</script>", tableInfo.getTableName(), columnScript, valuesScript);
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            // 表包含主键处理逻辑，如果不包含主键当普通字段处理
            KeyGenerator keyGenerator = NoKeyGenerator.INSTANCE;
            String keyProperty = tableInfo.getKeyProperty();
            String keyColumn = tableInfo.getKeyColumn();
            if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
                if (tableInfo.getIdType() == IdType.AUTO) {
                    keyGenerator = Jdbc3KeyGenerator.INSTANCE;
                }
            }
            return addInsertMappedStatement(mapperClass, modelClass, METHOD_NAME, sqlSource, keyGenerator, keyProperty, keyColumn);
        }
    }
}
