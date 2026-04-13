package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

@Config
class SwerbButItLowKeyWeird {

    @TeleOp(name = "Swerb I think")
    public class Swerby : LinearOpMode() {
        lateinit var one: DcMotor
        lateinit var two: DcMotor
        lateinit var three: DcMotor
        lateinit var four: DcMotor


        override fun runOpMode() {
            one = hardwareMap.get(DcMotor::class.java, "one")
            two = hardwareMap.get(DcMotor::class.java, "two")
            three = hardwareMap.get(DcMotor::class.java, "three")
            four = hardwareMap.get(DcMotor::class.java, "four")

            one.setDirection(DcMotorSimple.Direction.FORWARD)
            two.setDirection(DcMotorSimple.Direction.REVERSE)
            three.setDirection(DcMotorSimple.Direction.REVERSE)
            four.setDirection(DcMotorSimple.Direction.REVERSE)

            one.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
            two.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
            three.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
            four.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)


            waitForStart();

            while (opModeIsActive()) {
                var drive = -gamepad1.left_stick_y
                var turn = -gamepad1.right_stick_x
                var crab = -gamepad1.left_stick_x

                var OnePower = (drive + turn - crab) * 1.0
                var TwoPower = (drive - turn - crab) * 1.0
                var ThreePower = (drive - turn + crab) * 1.0
                var FourPower = (drive + turn + crab) * 1.0

                one.setPower(OnePower)
                two.setPower(TwoPower)
                three.setPower(ThreePower)
                four.setPower(FourPower)
            }

        }

    }
}
