import javax.swing.table.TableModel;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Bronco_search extends JFrame {
	
	
	
	//HOW TO OPEN NEW JFRAME IN BUTTON
	//https://stackoverflow.com/questions/17637195/how-to-make-a-jframe-button-open-another-jframe-class-in-netbeans?answertab=oldest#tab-tops
	
	private JLabel result;
	private JLabel institution;
	private JLabel term;
	private JLabel subject;
	private JLabel coursenum;
	private JLabel instructor_ln;
	private JLabel course_kw;
	
	private JComboBox institution_combo;
	private JComboBox term_combo;
	private JComboBox subject_combo;
	private JComboBox coursenum_combo;
	private JComboBox instructor_ln_combo;
	private JComboBox course_kw_combo;
	
	private JTextField coursenum_text;
	private JTextField instructor_ln_text;
	private JTextField course_kw_text;
	
	private JButton clear_button;
	private JButton search_button;
	
	private ImageIcon cpp_logo;
	private JLabel logo_label;

	private String[] classname = {"ECE 1101 - Electrical Circuit Analysis I" , 
			"ECE 2101 - Electrical Circuit Analysis II", 
			"ECE 2101L - Electrical Circuit Analysis II Laboratory", 
			"ECE 2200 - Introduction to Microelectronics Circuits",
			"ECE 2200L - Introduction to Microelectronics Circuits Laboratory",   
			"ECE 2300 - Digital Logic Design", 
			"ECE 2300L - Digital Logic Design Laboratory",  
			"ECE 3101 - Signals and Systems", 
			"ECE 3101 - Signals and Systems",
			"ECE 3101L - Signals and Systems Laboratory", 
			"ECE 3200 - Microelectronic Devices and Circuits",
			"ECE 3200L - Analog Microelectronics Laboratory", 
			"ECE 3250 - Electromagnetic Fields ", 
			"ECE 3301 - Introduction to Microcontrollers",
			"ECE 3301L - Introduction to Microcontrollers Laboratory",
			"ECE 3715 - Probability, Statistics, and Random Processes for Electrical and Computer Engineers", 
			"ECE 3715 - Probability, Statistics, and Random Processes for Electrical and Computer Engineers",
			"ECE 4064 - Professional Engineering Practice", 
			"ECE 4300 - Computer Architecture", 
			"ECE 4319 - Application Development Using JAVA", 
			"ECE 4705 - Communication Systems", 
			"ECE 4705L - Communication Systems Laboratory", 
			"ECE 4708 - Digital Signal Processing",
			};
	
	private List<String> classnameList = Arrays.asList(classname);
	
	private String[] coursenumber = {"1101" , 
			"2101", 
			"2101L", 
			"2200",
			"2200L",   
			"2300", 
			"2300L",  
			"3101", 
			"3101",
			"3101L", 
			"3200",
			"3200L", 
			"3250", 
			"3301",
			"3301L",
			"3715", 
			"3715",
			"4064", 
			"4300", 
			"4319", 
			"4705", 
			"4705L", 
			"4708",
			};
	private List<String> coursenumberList = Arrays.asList(coursenumber);
	
	
	private Integer[] classnumber ={50056, 
			50065, 
			51033, 
			50068,
			50069,   
			50984, 
			50985,  
			50073, 
			50074,
			50075, 
			50076,
			50077, 
			50078, 
			50464,
			50465,
			50085, 
			50086,
			51049, 
			50988, 
			50090, 
			50092, 
			50093,
			50094,
			};
	private List<Integer> classnumberList = Arrays.asList(classnumber);
	
	
	private String[] instructor = {"Anas Salah Eddin" , 
			"Zekeriya Aliyazicioglu", 
			"Saeed Monemi", 
			"Brita Olson",
			"Brita Olson",   
			"Mohamed Aly", 
			"Mohamed Aly",  
			"James Kang", 
			"Brita Olson",
			"Zekeriya Aliyazicioglu", 
			"Brita Olson",
			"Brita Olson", 
			"James Kang", 
			"Mohamed Rafiquzzaman",
			"Mohamed Rafiquzzaman",
			"Hong-Chuan Lin", 
			"Anas Salah Eddin",
			"Saeed Monemi", 
			"Mohamed Aly", 
			"Hong-Chuan Lin", 
			"Zekeriya Aliyazicioglu", 
			"Zekeriya Aliyazicioglu" ,
			"James Kang",
			};
	private List<String> instructorList = Arrays.asList(instructor);
	

	private String[] instructor_lastn ={"Eddin", 
									"Aliyazicioglu", 
									"Monemi ", 
									"Olson",
									"Olson",   
									"Aly", 
									"Aly",  
									"Kang", 
									"Olson",
									"Aliyazicioglu", 
									"Olson",
									"Olson", 
									"Kang", 
									"Rafiquzzaman",
									"Rafiquzzaman",
									"Lin", 
									"Eddin",
									"Monemi", 
									"Aly", 
									"Lin", 
									"Aliyazicioglu", 
									"Aliyazicioglu", 
									"Kang",
									};
	private List<String> instructorlnList = Arrays.asList(instructor_lastn);
	int startX = 100;
	int startY = 350;
	int spacing = 70;
	
	public Bronco_search() {
		
		super("Bronco Direct");
		setLayout(null);
		
		institution = new JLabel("Institution");
		institution.setLocation(100,30);
		institution.setSize(150,30);
		add(institution);
		String[] institution_string = {"Cal Poly Pomona"};
		institution_combo = new JComboBox(institution_string);
		institution_combo.setLocation(180,30);
		institution_combo.setSize(150,30);
		add(institution_combo);
		//add item listener

		term = new JLabel("Term");
		term.setLocation(100,80);
		term.setSize(150,30);
		add(term);
		String[] term_string = {"Summer Semester 2019"};
		term_combo = new JComboBox(term_string);
		term_combo.setLocation(180,80);
		term_combo.setSize(200,30);
		add(term_combo);
		//add item listener
		
		subject = new JLabel("Subject");
		subject.setLocation(100,130);
		subject.setSize(150,30);
		add(subject);
		String[] subject_string = {"Electrical & Computer Engineering"};
		subject_combo = new JComboBox(subject_string);
		subject_combo.setLocation(180,130);
		subject_combo.setSize(200,30);
		add(subject_combo);
		//add item listener
		//add item listener
		
		coursenum = new JLabel("Course Number");
		coursenum.setLocation(100,180);
		coursenum.setSize(150,30);
		add(coursenum);
		String[] coursenum_string = {"", "contains", "greater than or equal to", "is exactly", "less than or equal to"};
		coursenum_combo = new JComboBox(coursenum_string);
		coursenum_combo.setLocation(200,180);
		coursenum_combo.setSize(150,30);
		add(coursenum_combo);
		//add item listener
		coursenum_text = new JTextField();
		coursenum_text.setLocation(360,180);
		coursenum_text.setSize(150,30);
		add(coursenum_text);
		
		instructor_ln = new JLabel("Instructor Last Name");
		instructor_ln.setLocation(100,230);
		instructor_ln.setSize(150,30);
		add(instructor_ln);
		String[] instructor_ln_string = {"", "begins with", "contains", "is exactly"};
		instructor_ln_combo = new JComboBox(instructor_ln_string);
		instructor_ln_combo.setLocation(230,230);
		instructor_ln_combo.setSize(150,30);
		add(instructor_ln_combo);
		//add item listener
		instructor_ln_text = new JTextField();
		instructor_ln_text.setLocation(380,230);
		instructor_ln_text.setSize(150,30);
		add(instructor_ln_text);
		
		course_kw = new JLabel("Course Keyword");
		course_kw.setLocation(100,280);
		course_kw.setSize(150,30);
		add(course_kw);
		//add item listener
		course_kw_text = new JTextField();
		course_kw_text.setLocation(200,280);
		course_kw_text.setSize(150,30);
		add(course_kw_text);
		
		result = new JLabel("Result");
		result.setLocation(100,350);
		result.setSize(3000,30);
		add(result);
		
		//add Cpp_logo to GUI
		cpp_logo = new ImageIcon(getClass().getResource("cpp_logo.png"));
		logo_label = new JLabel(cpp_logo);
		logo_label.setLocation(550,40);
		logo_label.setSize(300,100);
		add(logo_label);
		
		//add JButtons and action listeners
		search_button = new JButton("Search");
		search_button.setLocation(300,400);
		search_button.setSize(100,30);
		add(search_button);
		//add search button action listener
		
		clear_button = new JButton("Clear");
		clear_button.setLocation(450,400);
		clear_button.setSize(100,20);
		add(clear_button);
		
		ButtonHandler bhandler = new ButtonHandler();
		search_button.addActionListener (bhandler);
		
		clear_button.addActionListener(bhandler);
		//add clear button action listener
	}
	
	private class ButtonHandler implements ActionListener 
	   {
	      // handle button event
	      public void actionPerformed( ActionEvent event )
	      {
	    	
	         if (event.getActionCommand() == "Clear") {
	        	 coursenum_text.setText("");
	        	 instructor_ln_text.setText("");
	        	 course_kw_text.setText("");
	      
	         }
	        	 
	         else if(event.getActionCommand() == "Search") {
	  
	        	 String coursenum_input = coursenum_text.getText();
	        	
	        	 
	        	 if(coursenumberList.contains(coursenum_input))
	        	 {
	        		 FileSearcher_CourseNum();
	        	 }
	     
	        	 //course number search
	        	 if(coursenumberList.contains(coursenum_input))
	        	 {       	 
		        	 List<String> coursenum_result =coursenumberList.stream()
		                     .filter(user -> user.contains(coursenum_input))
		                     .collect(Collectors.toList());
		        	 coursenum_result.forEach(System.out::println);
		        	 int i = coursenumberList.indexOf(coursenum_input);
		        	 result.setText(classname[i]+"      "+classnumber[i]+ "     " + instructor[i]);
	        	 }
	        	 
	        	 
	        	 //instructor search
	        	 String instructor_ln_input = instructor_ln_text.getText();    
	        	 if(instructorlnList.contains(instructor_ln_input))
	        	{
		        	 List<String> instructor_ln_result =instructorlnList.stream()
		                     .filter(user -> user.contains(instructor_ln_input))
		                     .collect(Collectors.toList());
		        	 //instructor_ln_result.forEach(System.out::println);
		        	 int j = instructorlnList.indexOf(instructor_ln_input);
		        	 //System.out.println(classname[j]+"\t"+classnumber[j]+ "\t" + instructor[j]);
		        	 result.setText(classname[j]+"      "+classnumber[j]+ "     " + instructor[j]);
		        	 
	        	 }
	        	 
	        	 //coursekeyword_search;
	        	 
	        	 String course_kw_input = course_kw_text.getText(); 
	        	
	        	 
	        	 if(!course_kw_input.equals(""))
	        	 {
		        	 List <String> listClone = new ArrayList<String>(); 
		             Pattern pattern = Pattern.compile(course_kw_input,Pattern.CASE_INSENSITIVE); //incase u r not concerned about upper/lower case
		             for (String string : classnameList) {
		                 if(pattern.matcher(string).find()) {
		                     listClone.add(string);
		                     continue;
		                 }
		             }
		            // System.out.println(listClone);
		             result.setText(listClone.toString());
	        	 }
	         }
	      } 
	   } 
	
	public class User{
			public String classname_user;
			public String coursenum_user;
			public int classnum_user;
			public String instructor_user;
			
			public User(String classname, String coursenum, int classnum, String instructor )
			{
				this.classname_user= classname;
				this.coursenum_user=coursenum;
				this.classnum_user = classnum;
				this.instructor_user = instructor;
		}
	}
	
	public Bronco_search ListUsers()
	{
		{
			String classname[] = {"ECE 1101 - Electrical Circuit Analysis I" , "ECE 2101 - Electrical Circuit Analysis II ", "ECE 2101L - Electrical Circuit Analysis II Laboratory ", "ECE 2300 - Digital Logic Design ", "ECE 2300L - Digital Logic Design Laboratory ", "ECE 3101L - Signals and Systems Laboratory ", "ECE 3200 - Microelectronic Devices and Circuits ", "ECE 3200L - Analog Microelectronics Laboratory ", "ECE 3715 - Probability, Statistics, and Random Processes for Electrical and Computer Engineers ", "ECE 4064 - Professional Engineering Practice ", "ECE 4300 - Computer Architecture ", "ECE 4319 - Application Development Using JAVA ", "ECE 4705 - Communication Systems ", "ECE 4705L - Communication Systems Laboratory " };
	 		String coursenum []= {"ECE 1101", "ECE 2101", "ECE 2101L", "ECE 2300", "ECE 2300L", "ECE 3101L", "ECE 3200", "ECE 3200L", "ECE 3715","ECE 4064", "ECE 4300", "ECE 4319", "ECE 4705", "ECE 4705L"};
	 		Integer classnum []= {50056, 50065, 51033, 50984, 50985, 50075, 50076,50077,50085,50086,51049,50988,50090,50092,50093};
	 		String instructor[]  = {"Anas Salah Eddin","Zekeriya Aliyazicioglu","Saeed Monemi","Mohamed Aly", "Mohamed Aly", "Zekeriya Aliyazicioglu","Brita Olson","Brita Olson", "Hong-Chuan Lin","Anas Salah Eddin","Saeed Monemi","Mohamed Aly", "Hong-Chuan Lin", "Zekeriya Aliyazicioglu","Zekeriya Aliyazicioglu"};
	 		Bronco_search list = new Bronco_search();
	 		list.addValues(classname, coursenum, classnum, instructor);
	 		return list;
			
		}
		//User u1 = new User(classnamelist[i],)
	}
	
	public void addValues(String classname[], String coursenum[], Integer classnum[], 
	        String instructor[]) 
	{ 
	// local custom arraylist of data type 
	// Data having (int, String, int, long) type 
	// from the class 
		ArrayList<User> list=new ArrayList<>(); 
		
		for (int i = 0; i < list.size(); i++) 
		{ 
		// create an object and send values to the 
		// constructor to be saved in the Data class 
			list.add(new User(classname[i], coursenum[i], classnum[i], 
		                            instructor[i])); 
		} 
		
		// after adding values printing the values to test 
		// the custom arraylist 
		printValues(list); 
	} 
	
	public void printValues(ArrayList<User> list) 
	{ 
	    // list- the custom arraylist is sent from 
	    // previous function 
	
	    for (int i = 0; i < list.size(); i++) 
	    { 
	
	        User data = list.get(i);
	
	        result.setText(data.classname_user+" "+data.coursenum_user+" "
	                           +data.classnum_user+" "+data.instructor_user); 
	    } 
	} 
	
	public void FileSearcher_CourseNum(){
		int tokencount;
		
		String s = coursenum_text.getText();
		int linecount=0;
		String line;
		String words[]=new String[500];
					   while (coursenumberList.contains(s))
						  {
						  linecount++;
						  int indexfound=coursenumberList.indexOf(coursenum_text.getText());
									  if (indexfound>-1)
									  {
									  //System.out.println("Word was found at position::" +indexfound+ "::on line"+linecount);
									  System.out.println("\n");
									  line=s;
									  result.setText(classname[indexfound]+"\t"+classnumber[indexfound]+ "\t" + instructor[indexfound]);
									  int idx=0;
									  StringTokenizer st= new StringTokenizer(line);
								
									  }
									  break;
						  }
	}
	
	public void FileSearcher_Instructor(){
		int tokencount;
		
		String s = instructor_ln_text.getText();
		int linecount=0;
		String line;
		String words[]=new String[500];
					   while (s!=null)
						  {
						  linecount++;
						  int indexfound=instructorlnList.indexOf(instructor_ln_text.getText());
						  
									  if (indexfound>-1)
									  {
									
									  System.out.println("\n");
									  line=s;
									  result.setText(classname[indexfound]+"\t"+classnumber[indexfound]+ "\t" + instructor[indexfound]);
									  int idx=0;
									  StringTokenizer st= new StringTokenizer(line);
								
									  }
									  break;
						  }
	}
	
	public static void main(String[] args) {
			
		Bronco_search bronco_direct = new Bronco_search(); 
			bronco_direct.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			bronco_direct.setSize( 900, 500 ); // set frame size
			bronco_direct.setVisible( true ); // display frame
			
		}
	
		
		
	
	}
