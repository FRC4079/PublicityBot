// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NoiseMakers extends SubsystemBase {
  /** Creates a new NoiseMakers. */
  Relay leftHorn;
  Relay rightHorn;

  public NoiseMakers() {
    leftHorn = new Relay(2);
    rightHorn = new Relay(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void makeNoise() {
    leftHorn.set(Value.kForward);
    rightHorn.set(Value.kForward);
  }

  public void stop() {
    leftHorn.set(Value.kOff);
    rightHorn.set(Value.kOff);
  }
}
