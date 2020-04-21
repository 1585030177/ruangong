import java.io.*;
import java.util.*;
//��Ӱ����
enum MovieType implements Serializable{
	ϲ��Ƭ,�ƻ�Ƭ;
}
//��Ӱ
class Movie implements Serializable{
	String movieName;
	MovieType movieType;
	Movie(){
		
	}
	Movie (String movieName,MovieType movieType){
		this.movieName=movieName;
		this.movieType=movieType;
	}
}
//��Ӱ��ӳʱ���
class MovieSchedule implements Serializable{
	String screeningHall;
	String time;
	MovieSchedule(){
		
	}
	MovieSchedule(String screeningHall,String time){
		this.screeningHall=screeningHall;
		this.time=time;
	}
	
}
//��λ
class Seat implements Serializable{
	String seat;
	Seat(){
		
	}
	Seat(String seat){
		this.seat=seat;
	}
}
//��ӰƱ
class Ticket implements Serializable{
	Movie movie;
	MovieSchedule movieSchedule;
	Seat seat;
	Ticket(){
		
	}
	Ticket(Movie movie,MovieSchedule movieSchedule,Seat seat){
		this.movie=movie;
		this.movieSchedule=movieSchedule;
		this.seat=seat;
	}
	public void printTicket(){
		//��ӡƱ����ϸ��Ϣ 
		System.out.println(movie.movieName);
		System.out.println("���ͣ�"+movie.movieType);
		System.out.println("��ӳ����"+movieSchedule.screeningHall);
		System.out.println("ʱ�䣺"+movieSchedule.time);
		System.out.println("��λ��"+seat.seat);
	}
}

public class SerializationDemo {

	public static void main(String[] args) {
		MovieType mt1=MovieType.ϲ��Ƭ;
		MovieType mt2=MovieType.�ƻ�Ƭ;
		try {
			File file=new File("movie1.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			Ticket t1=new Ticket();
			Movie m1=new Movie("����ʯͷ",mt1);
			MovieSchedule ms1=new MovieSchedule("��ӳ��1","2010��7��12�� 20ʱ20��");
			Seat s1=new Seat("10��12��");
			t1.movie=m1;
			t1.movieSchedule=ms1;
			t1.seat=s1;
			t1.printTicket();
			oos.writeObject(t1);
			oos.close();
			fos.close();
			System.out.println("********************");
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Ticket t2=(Ticket)ois.readObject();
			t2.seat.seat="10��13��";
			t2.printTicket();
			oos.close();
			fos.close();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("********************");
		try {
			File file=new File("movie2.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			Ticket t1=new Ticket();
			Movie m1=new Movie("2012",mt2);
			MovieSchedule ms1=new MovieSchedule("��ӳ��2","2010��7��14�� 19ʱ40��");
			Seat s1=new Seat("8��8��");
			t1.movie=m1;
			t1.movieSchedule=ms1;
			t1.seat=s1;
			t1.printTicket();
			oos.writeObject(t1);
			oos.close();
			fos.close();
			System.out.println("********************");
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Ticket t2=(Ticket)ois.readObject();
			t2.seat.seat="8��9��";
			t2.printTicket();
			oos.close();
			fos.close();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("********************");
	}

}
