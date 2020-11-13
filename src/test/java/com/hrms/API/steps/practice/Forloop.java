package com.hrms.API.steps.practice;

public class Forloop {
	
		public static void main(String[] args) {
			System.out.println("DO NOT TRY TO PRINT FULL PROGRAM BECAUSE NOT EVERTHING WILL PRINT");
			System.out.println();
			System.out.println("MAKE SURE TO READ COMMENTED LINES FOR FURTHER UNDERSTANDING!!!");
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------UNDERSTANDING OUTER AND INNER LOOPS------------");
			for (int i = 1; i <= 3; i++) {
				System.out.println("ENTERING OUTER LOOP");
				System.out.println(i);
				System.out.println("EXITING OUTER LOOP");
				for (int j = 1; j <= 3; j++) {
					System.out.println("ENTERING INNER LOOP");
					System.out.println(
							"ONCE WE ARE INSIDE INNER LOOP(NESTED FOR LOOP) THEN THIS LOOP WILL ITERATE UNTIL CONDITION IS FALSE THEN WILL GO BACK TO OUTER LOOP AND START AGAIN");
					System.out.println(j);
					System.out.println("ENTERING INNER LOOP");
				}
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------FURTHER EXPLANATION - READ COMMENTED LINES!------------");
			for (int a = 1; a <= 4; a++) {
				System.out.println(
						"FIRST WE ENTER OUTER LOOP AND IF THE CONDITION IS TRUE IMMEDIATELY IT WILL GO TO NESTED LOOP");
				System.out.println("FIRST ITERATION WILL START, THEN SECOND, THEN THIRD");
				for (int b = 1; b <= 4; b++) {
					System.out
							.println("THIS IS THE INNER LOOP SO ALL ITERATIONS(LOOPS) WILL HAPPEN UNTIL CONDITION IS FALSE"
									+ "ONCE IT IS FALE THEN IT WILL GO TO OUTER LOOP TO START NEXT ITERATION(IF THERE IS ONE) "
									+ "AND WILL START AGAIN AND FULL EXECUTION ENDS WHEN OUTER LOOP CONDITION IS FALSE");
					System.out.println(a + "" + b);
				}
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING A CLOCK WITH THAT GOES UP TO 12:59------------");
			for (int c = 1; c <= 12; c++) {
				for (int d = 1; d <= 59; d++) {
					if (d < 10) {
						System.out.println(c + ":0" + d);
					} else {
						System.out.println(c + ":" + d);
					}
				}
			}
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println();
			System.out.println("------------PRINTING CAR ODOMETER EXAMPLE THAT GOES UP TO 9999------------");
			System.out.println("ODOMETER SAMPLE CANCELLED OUT BECAUSE PROGRAM IS VERY LONG SO MAKE SURE TO UNCOMMENT IT TO SEE IT!");
			System.out.println();
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\"");
			//THIS WAS CANCELLED BECAUSE PRINTING OF THIS PROGRAM IS VERY LONG AND YOU WONT TO SEE PRINTING OF OTHER PROGRAMS - 
//			for (int firstOdometerNumber = 0; firstOdometerNumber < 10; firstOdometerNumber++) {
	//
//				for (int secondOdometerNumber = 0; secondOdometerNumber < 10; secondOdometerNumber++) {
	//
//					for (int thirdOdometerNumber = 0; thirdOdometerNumber < 10; thirdOdometerNumber++) {
	//
//						for (int fourthOdometerNumber = 0; fourthOdometerNumber < 10; fourthOdometerNumber++) {
	//
//							System.out.println(firstOdometerNumber + " " + secondOdometerNumber + " " + thirdOdometerNumber
//									+ " " + fourthOdometerNumber);
//						}
//					}
//				}
//			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING STARS USING FOR LOOP------------");
			// this will print 5 stars
			for (int e = 1; e <= +5; e++) {
				System.out.println("*");
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING STAR PATTERN IN LINES------------");
			for (int h = 1; h <= 4; h++) {
				for (int g = 1; g <= 5; g++) {
					// printing stars in line by taking "ln" away from System.out.print"ln"
					System.out.print("* ");
				}
				// This will print new empty line - cancel it so you can see what happens when
				// you run it
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING 123456789------------");
			for (int k = 1; k <= 5; k++) {
				for (int l = 1; l <= 9; l++) {
					System.out.print(l);
				}
				System.out.println();
			}
			// Printing patterns
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING INCREMENTING STAR PATTERN------------");
			// first specify rows
			for (int rows = 1; rows <= 9; rows++) {
				// then specify columns
				for (int columns = 1; columns <= rows; columns++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println("------------PRINTING INCREMENTING AND DECREMENTING STAR PATTERN------------");
			for (int n = 1; n <= 20; n++) {
				for (int o = 1; o <= n; o++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			for (int p = 1; p <= 20; p++) {
				for (int q = 19; q >= p; q--) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
	}

