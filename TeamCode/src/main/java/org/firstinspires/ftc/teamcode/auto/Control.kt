package org.firstinspires.ftc.teamcode.auto

import com.acmerobotics.roadrunner.AccelConstraint
import com.acmerobotics.roadrunner.AngularVelConstraint
import com.acmerobotics.roadrunner.MinVelConstraint
import com.acmerobotics.roadrunner.ProfileAccelConstraint
import com.acmerobotics.roadrunner.VelConstraint
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive

fun getVelocityConstraint(maxVel: Double, maxAngVel: Double = MecanumDrive.PARAMS.maxAngVel): VelConstraint {
    return MinVelConstraint(listOf(
        AngularVelConstraint(maxAngVel),
        VelConstraint { _, _, _ -> maxVel }
    ))
}

fun getAccelerationConstraint(maxAccel: Double): AccelConstraint {
    return ProfileAccelConstraint(-maxAccel, maxAccel)
}