package tests;

import java.awt.Point;

import rush_hour.Vehicle;

public final class TestsUtils {
	public static Vehicle getVehicle(char identifier, boolean orientation, int size, Point startPoint, Point endPoint) {
		Vehicle vehicleToBuild = new Vehicle(identifier, startPoint);
		vehicleToBuild.setEndPos(endPoint);
		vehicleToBuild.setOrientation(orientation);
		vehicleToBuild.setSize(size);

		return vehicleToBuild;
	}
}
