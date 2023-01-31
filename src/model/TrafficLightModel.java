package model;

public class TrafficLightModel {
	private int timeRed;
	private int timeGreen;
	private int timeYellow;
	public TrafficLightModel() {
		this.timeRed = 10;
		this.timeGreen = 8;
		this.timeYellow = 2;
	}
	public int getTimeRed() {
		return timeRed;
	}
	public void setTimeRed(int timeRed) {
		this.timeRed = timeRed;
	}
	public int getTimeGreen() {
		return timeGreen;
	}
	public void setTimeGreen(int timeGreen) {
		this.timeGreen = timeGreen;
	}
	public int getTimeYellow() {
		return timeYellow;
	}
	public void setTimeYellow(int timeYellow) {
		this.timeYellow = timeYellow;
	}
}
