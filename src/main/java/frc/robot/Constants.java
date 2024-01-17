// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.math.Matter;


public final class Constants {
  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; //TODO, this should be robot mass in kg
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8/*inches of pidgeon off ground */)), ROBOT_MASS);//TODO inches off the ground
  public static final double LOOP_TIME  = 0.13; //TODO tune this till its right

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final double LEFT_X_DEADBAND = 0.01;
    public static final double LEFT_Y_DEADBAND = 0.01;
    public static final double RIGHT_X_DEADBAND = 0.01;

  }

}
