package com.sample.model;

public class Ingredient {

	private String label;
	private String metricValue;
	private Metric metric;

	public Ingredient(String label, String metricValue, Metric metric) {
		this.label = label;
		this.metricValue = metricValue;
		this.metric = metric;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMetricValue() {
		return metricValue;
	}

	public void setMetricValue(String metricValue) {
		this.metricValue = metricValue;
	}

	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

}
