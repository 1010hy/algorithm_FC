package ch06;

import ch06.Maze;
import ch06.Robot;

//실행하기
public class MazeTest {

	public static void main(String[] args) {
		
		Robot robot;
		System.out.println("출구는 (7,7)입니다.");
		
		robot = new Robot();	
				
		robot.findPath( 0,0, 7,7);
		robot.showPath();
		
	}
}
