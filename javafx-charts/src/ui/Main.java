package ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();

		GridPane gp = new GridPane();

		gp.add(pieChart(), 0, 0);
		gp.add(lineChart(), 1, 0);
		gp.add(scatterChart(), 0, 1);
		gp.add(areaChart(), 1, 1);
		gp.add(bubbleChart(), 0, 2);
		gp.add(barChart(), 1, 2);
		root.setCenter(gp);

		Scene scene = new Scene(root, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Charts");
		primaryStage.show();
	}

	public PieChart pieChart() {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Grapefruit", 13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10),
				new PieChart.Data("Pears", 22), new PieChart.Data("Apples", 30));
		final PieChart pieChart = new PieChart(pieChartData);
		pieChart.setTitle("Imported Fruits");

		return pieChart;

	}

	public LineChart lineChart() {
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("Stock Monitoring, 2010");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("My portfolio");
		// populating the series with data
		series.getData().add(new XYChart.Data(1, 23));
		series.getData().add(new XYChart.Data(2, 14));
		series.getData().add(new XYChart.Data(3, 15));
		series.getData().add(new XYChart.Data(4, 24));
		series.getData().add(new XYChart.Data(5, 34));
		series.getData().add(new XYChart.Data(6, 36));
		series.getData().add(new XYChart.Data(7, 22));
		series.getData().add(new XYChart.Data(8, 45));
		series.getData().add(new XYChart.Data(9, 43));
		series.getData().add(new XYChart.Data(10, 17));
		series.getData().add(new XYChart.Data(11, 29));
		series.getData().add(new XYChart.Data(12, 25));

		lineChart.getData().add(series);

		return lineChart;
	}

	public BubbleChart bubbleChart() {
		final NumberAxis xAxis = new NumberAxis(1, 53, 4);
		final NumberAxis yAxis = new NumberAxis(0, 80, 10);
		final BubbleChart<Number, Number> blc = new BubbleChart<>(xAxis, yAxis);
		xAxis.setLabel("Week");
		yAxis.setLabel("Product Budget");
		blc.setTitle("Budget Monitoring");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Product 1");
		series1.getData().add(new XYChart.Data(3, 35));
		series1.getData().add(new XYChart.Data(12, 60));
		series1.getData().add(new XYChart.Data(15, 15));
		series1.getData().add(new XYChart.Data(22, 30));
		series1.getData().add(new XYChart.Data(28, 20));
		series1.getData().add(new XYChart.Data(35, 41));
		series1.getData().add(new XYChart.Data(42, 17));
		series1.getData().add(new XYChart.Data(49, 30));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Product 2");
		series2.getData().add(new XYChart.Data(8, 15));
		series2.getData().add(new XYChart.Data(13, 23));
		series2.getData().add(new XYChart.Data(15, 45));
		series2.getData().add(new XYChart.Data(24, 30));
		series2.getData().add(new XYChart.Data(38, 78));
		series2.getData().add(new XYChart.Data(40, 41));
		series2.getData().add(new XYChart.Data(45, 57));
		series2.getData().add(new XYChart.Data(47, 23));

		blc.getData().addAll(series1, series2);

		return blc;
	}

	public AreaChart areaChart() {
		final NumberAxis xAxis = new NumberAxis(1, 31, 1);
		final NumberAxis yAxis = new NumberAxis();
		final AreaChart<Number, Number> ac = new AreaChart<>(xAxis, yAxis);
		ac.setTitle("Temperature Monitoring (in Degrees C)");

		XYChart.Series seriesApril = new XYChart.Series();
		seriesApril.setName("April");
		seriesApril.getData().add(new XYChart.Data(1, 4));
		seriesApril.getData().add(new XYChart.Data(3, 10));
		seriesApril.getData().add(new XYChart.Data(6, 15));
		seriesApril.getData().add(new XYChart.Data(9, 8));
		seriesApril.getData().add(new XYChart.Data(12, 5));
		seriesApril.getData().add(new XYChart.Data(15, 18));
		seriesApril.getData().add(new XYChart.Data(18, 15));
		seriesApril.getData().add(new XYChart.Data(21, 13));
		seriesApril.getData().add(new XYChart.Data(24, 19));
		seriesApril.getData().add(new XYChart.Data(27, 21));
		seriesApril.getData().add(new XYChart.Data(30, 21));

		XYChart.Series seriesMay = new XYChart.Series();
		seriesMay.setName("May");
		seriesMay.getData().add(new XYChart.Data(1, 20));
		seriesMay.getData().add(new XYChart.Data(3, 15));
		seriesMay.getData().add(new XYChart.Data(6, 13));
		seriesMay.getData().add(new XYChart.Data(9, 12));
		seriesMay.getData().add(new XYChart.Data(12, 14));
		seriesMay.getData().add(new XYChart.Data(15, 18));
		seriesMay.getData().add(new XYChart.Data(18, 25));
		seriesMay.getData().add(new XYChart.Data(21, 25));
		seriesMay.getData().add(new XYChart.Data(24, 23));
		seriesMay.getData().add(new XYChart.Data(27, 26));
		seriesMay.getData().add(new XYChart.Data(31, 26));

		ac.getData().addAll(seriesApril, seriesMay);

		return ac;
	}

	public ScatterChart scatterChart() {
		final NumberAxis xAxis = new NumberAxis(0, 10, 1);
		final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
		final ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);
		xAxis.setLabel("Age (years)");
		yAxis.setLabel("Returns to date");
		sc.setTitle("Investment Overview");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Equities");
		series1.getData().add(new XYChart.Data(4.2, 193.2));
		series1.getData().add(new XYChart.Data(2.8, 33.6));
		series1.getData().add(new XYChart.Data(6.2, 24.8));
		series1.getData().add(new XYChart.Data(1, 14));
		series1.getData().add(new XYChart.Data(1.2, 26.4));
		series1.getData().add(new XYChart.Data(4.4, 114.4));
		series1.getData().add(new XYChart.Data(8.5, 323));
		series1.getData().add(new XYChart.Data(6.9, 289.8));
		series1.getData().add(new XYChart.Data(9.9, 287.1));
		series1.getData().add(new XYChart.Data(0.9, -9));
		series1.getData().add(new XYChart.Data(3.2, 150.8));
		series1.getData().add(new XYChart.Data(4.8, 20.8));
		series1.getData().add(new XYChart.Data(7.3, -42.3));
		series1.getData().add(new XYChart.Data(1.8, 81.4));
		series1.getData().add(new XYChart.Data(7.3, 110.3));
		series1.getData().add(new XYChart.Data(2.7, 41.2));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Mutual funds");
		series2.getData().add(new XYChart.Data(5.2, 229.2));
		series2.getData().add(new XYChart.Data(2.4, 37.6));
		series2.getData().add(new XYChart.Data(3.2, 49.8));
		series2.getData().add(new XYChart.Data(1.8, 134));
		series2.getData().add(new XYChart.Data(3.2, 236.2));
		series2.getData().add(new XYChart.Data(7.4, 114.1));
		series2.getData().add(new XYChart.Data(3.5, 323));
		series2.getData().add(new XYChart.Data(9.3, 29.9));
		series2.getData().add(new XYChart.Data(8.1, 287.4));
		sc.getData().addAll(series1, series2);

		return sc;
	}

	public BarChart barChart() {
		final String austria = "Austria";
		final String brazil = "Brazil";
		final String france = "France";
		final String italy = "Italy";
		final String usa = "USA";

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle("Country Summary");
		xAxis.setLabel("Country");
		yAxis.setLabel("Value");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("2003");
		series1.getData().add(new XYChart.Data(austria, 25601.34));
		series1.getData().add(new XYChart.Data(brazil, 20148.82));
		series1.getData().add(new XYChart.Data(france, 10000));
		series1.getData().add(new XYChart.Data(italy, 35407.15));
		series1.getData().add(new XYChart.Data(usa, 12000));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("2004");
		series2.getData().add(new XYChart.Data(austria, 57401.85));
		series2.getData().add(new XYChart.Data(brazil, 41941.19));
		series2.getData().add(new XYChart.Data(france, 45263.37));
		series2.getData().add(new XYChart.Data(italy, 117320.16));
		series2.getData().add(new XYChart.Data(usa, 14845.27));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("2005");
		series3.getData().add(new XYChart.Data(austria, 45000.65));
		series3.getData().add(new XYChart.Data(brazil, 44835.76));
		series3.getData().add(new XYChart.Data(france, 18722.18));
		series3.getData().add(new XYChart.Data(italy, 17557.31));
		series3.getData().add(new XYChart.Data(usa, 92633.68));

		bc.getData().addAll(series1, series2, series3);
		

		return bc;
	}

}
