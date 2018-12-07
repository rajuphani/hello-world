package step2;

import java.util.List;

public class QueryParameter {
	
	private String queryString;
	private String file;
	private String baseQuery;
	private List<Restriction> restrictions;
	private List<String> fields;
	private String QUERY_TYPE;
	private String where_condition_filter;
	private List<String> logicalOperators;
	private List<AggregateFunction> aggregateFunctions;
	private String relational_operators;
	private List<String> order_by_field;
	private List<String> group_by_field;
	private List<String> aggregate_fields;
	
	
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(String baseQuery) {
		this.baseQuery = baseQuery;
	}
	public List<Restriction> getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public String getQUERY_TYPE() {
		return QUERY_TYPE;
	}
	public void setQUERY_TYPE(String qUERYTYPE) {
		QUERY_TYPE = qUERYTYPE;
	}
	public String getWhere_condition_filter() {
		return where_condition_filter;
	}
	public void setWhere_condition_filter(String whereConditionFilter) {
		where_condition_filter = whereConditionFilter;
	}
	public List<String> getLogicalOperators() {
		return logicalOperators;
	}
	public void setLogicalOperators(List<String> logicalOperators) {
		this.logicalOperators = logicalOperators;
	}
	public List<AggregateFunction> getAggregateFunctions() {
		return aggregateFunctions;
	}
	public void setAggregateFunctions(List<AggregateFunction> aggregateFunctions) {
		this.aggregateFunctions = aggregateFunctions;
	}
	public String getRelational_operators() {
		return relational_operators;
	}
	public void setRelational_operators(String relationalOperators) {
		relational_operators = relationalOperators;
	}
	public List<String> getOrder_by_field() {
		return order_by_field;
	}
	public void setOrder_by_field(List<String> orderByField) {
		order_by_field = orderByField;
	}
	public List<String> getGroup_by_field() {
		return group_by_field;
	}
	public void setGroup_by_field(List<String> groupByField) {
		group_by_field = groupByField;
	}
	public List<String> getAggregate_fields() {
		return aggregate_fields;
	}
	public void setAggregate_fields(List<String> aggregateFields) {
		aggregate_fields = aggregateFields;
	}
	
	public String toString(){
		return "Query: " + queryString + "\n" + "File name: " + file + "\n" + "Base Query: " + baseQuery + "\n" + "Restrictions: " + restrictions + "\n" + "Group By fileds: " + group_by_field.toString();
	}
	
	
	

}
