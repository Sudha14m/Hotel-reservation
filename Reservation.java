
public class Reservation
{
	private String name;
	private int roomNumber;

	public Reservation(String person)
	{
		this.name=person;
		roomNumber=0;
	}
	public Reservation(String person, int room)
	{
		this.name=person;
		roomNumber=room;
	}
	public void setRoom(int newroom)
	{
		this.roomNumber=newroom;
	}
	public void setName(String newname)
	{
		this.name=newname;
	}
	public int getRoom()
	{
		return roomNumber;
	}
	public String getName()
	{
		return name;
	}
}
