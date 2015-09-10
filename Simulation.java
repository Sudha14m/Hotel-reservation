import java.io.*;

public class Simulation
{
	private static String readLine()
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			return stdin.readLine();
		}
		catch(Exception e){}
		return null;
	}

	public static void print()
	{
		System.out.println("\n\nSelect options:");
		System.out.println("1 - Reserve a room for someone");
		System.out.println("2 - Reserve a particular room");
		System.out.println("3 - Cancel someone's reservations");
		System.out.println("4 - Show all reservations");
		System.out.println("5 - Build some more rooms for the hotel");
		System.out.println("0 - Exit");
		
	}
	public static void main(String[] args)
	{
		Hotel h = new Hotel();
		String name, num;
		int roomnum;
		System.out.println("Hotel Room Accomodation");
		print();
		while(true)
		{
			System.out.print("\nCommand: ");
			System.out.flush();
			String command = readLine();
			if((command == "0"))
			{
				System.out.println("Good bye");
				break;
			}

			if(command.equalsIgnoreCase("1"))
			{
				System.out.print("Name: ");
				System.out.flush();
				name = readLine();
				roomnum = -1;
				if(!((name==null) || (name.equals(""))))
					roomnum = h.reserveRoom(name);
				if(roomnum==-1)
					System.out.println("No reservation for you!");
				else
					System.out.println(name+" reserved room "+roomnum);
			}
			if(command.equalsIgnoreCase("2"))
			{
				System.out.print("Name: ");
				 
				name = readLine();
				System.out.print("Room number: ");
			 
				num = readLine();

				if((name==null) || (name.equals("")) || (num==null))
					roomnum = -1;
				else{
					try{
						roomnum = Integer.parseInt(num);
					}catch(Exception e){
						roomnum = -1;
					}
				}
				if(!h.reserveRoom(name, roomnum))
					System.out.println("No reservation for you!");
				else
					System.out.println(name+" reserved room "+roomnum);
			}

			else if(command.equalsIgnoreCase("3")){
				System.out.print("Name: ");
			 
				name = readLine();

				if(!((name==null) || (name.equals("")))){
					h.cancelReservations(name);
					System.out.println(name+" now has no reservations.");
				}else{
					System.out.println("Who?");
				}
			}

			else if(command.equalsIgnoreCase("4")){
				h.printReservations();
			}

			else if(command.equalsIgnoreCase("5")){
				System.out.print("How many: ");
				 
				num = readLine();

				roomnum = -1;
				if(num!=null){
					try{
						roomnum = Integer.parseInt(num);
					}catch(Exception e){
						roomnum = -1;
					}
				}

				if(h.buildRooms(roomnum))
					System.out.println("Added "+roomnum+" more rooms");
				else
					System.out.println("No more rooms to accomodate");
			}
			else{
				print(); 

			}
		}
	}
}
