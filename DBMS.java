// Project Title : Customised database management system or Student Management System using data structure

class node
{
    private static int counter = 1;
    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B,String C,int D)
    {
        Rno = counter;
        counter++;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }

}

class database
{
    private node first;
    
    public database()
    {
        first = null;
        System.out.println("Database Initialized successfully");
        System.out.println("Student Table gets created successfully");
    }

    // InsertLast
    // Insert into table values(1,"Amit","Pune",89)
    public void InsertIntoTable(String Name,String City,int Marks)
    {
        node newn = new node(Name, City, Marks);
        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next=newn;
        }
        System.out.println("One record gets inserted successfully");
    }
    // select * from student
    public void SelectStarFromWhereCity(String str)
    {
        System.out.println("Data from student table where city is : "+str);

        System.out.println("------------------------------------------------------------");
        node temp = first;
        while(temp!=null)
        {
            if(str.equals(temp.City))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("------------------------------------------------------------");
    }

    // select * from student where city = '______';
    public void SelectStarFrom()
    {
        System.out.println("Data from student table is : ");

        System.out.println("------------------------------------------------------------");
        node temp = first;
        while(temp!=null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("------------------------------------------------------------");
    }

    // select count(Marks) from student;
    public void SelectCount()
    {
        node temp = first;
        int iCnt = 0;

        while(temp != null)
        {
            temp=temp.next;
            iCnt++;
        }
        System.out.println("Number of records in table : "+iCnt);
    }

    // select Sum(Marks) from student;
    public void SelectSum()
    {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp=temp.next;
        }
        System.out.println("Summation of Marks column is : "+iSum);
    }

    // select AVG(Marks) from student;
    public void SelectAvg()
    {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            iCnt++;
            temp=temp.next;
        }
        System.out.println("Average of Marks is : "+((float)iSum/iCnt));
    }

    // select MAX(Marks) from student;
    public void SelectMAX()
    {
        node temp = first;
        int iMax = 0;

        if(temp!=null)
        {
            iMax = temp.Marks;
        }
        while(temp != null)
        {
            if(temp.Marks>iMax)
            {
                iMax = temp.Marks;
            }
            temp=temp.next;
        }
        System.out.println("Maximum of Marks is : "+iMax);
    }

    // select MIN(Marks) from student;
    public void SelectMIN()
    {
        node temp = first;
        int iMin = 0;

        if(temp!=null)
        {
            iMin = temp.Marks;
        }
        while(temp != null)
        {
            if(temp.Marks<iMin)
            {
                iMin = temp.Marks;
            }
            temp=temp.next;
        }
        System.out.println("Manimum of Marks is : "+iMin);
    }

    // select * from students where name = '____';
    public void SelectStarFromName(String str)    
    {
        node temp = first;

        System.out.println("Information of a students from student table with name: "+str);
        System.out.println("------------------------------------------------------------");

        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("------------------------------------------------------------");
    }

    // update student set City = '____' where Rno = '____';
    public void UpdateCity(int no,String str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == no)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record Gets updated...");
    }

    // delete from student where Rno = ____;
    public void DeleteFrom(int no)
    {
        node temp = first;

        // if LL is empty
        if(temp == null)
        {
            return;
        }

        // if first node is targeted node
        if(temp.Rno == no)
        {
            first = first.next;
            System.out.println("Record Deleted Successfully...");
            return;
        }

        while(temp.next != null)
        {
            if(temp.next.Rno == no)
            {
                temp.next = temp.next.next;
                System.out.println("Record Deleted Successfully...");
                break;
            }
            temp = temp.next;
        }
    }
}

class DBMS
{
    public static void main(String args [])
    {
        database obj = new database();
        obj.InsertIntoTable("Amit", "Pune", 89);
        obj.InsertIntoTable("Pooja", "Mumbai", 95);
        obj.InsertIntoTable("Gauri", "Pune", 90);
        obj.InsertIntoTable("Amit", "Nagar", 81);
        obj.InsertIntoTable("Rahul", "Satara", 80);
        obj.InsertIntoTable("Neha", "Pune", 78);

        obj.SelectStarFrom();

        obj.SelectStarFromWhereCity("Pune");

        obj.SelectCount();

        obj.SelectSum();

        obj.SelectAvg();

        obj.SelectMAX();

        obj.SelectMIN();

        obj.SelectStarFromName("Amit");

        obj.UpdateCity(3, "Nashik");
        obj.SelectStarFrom();

        obj.DeleteFrom(5);
        obj.SelectStarFrom();

        obj.InsertIntoTable("Rukhmini", "Kolhapur", 77);
        obj.SelectStarFrom();
    }
}

/*
    --------------Supported Queries-------------------

    1 : insert into student values('Amit','Pune',78);
    2 : select * from student;
    3 : select * from student where city = '_____';
    4 : select count(Marks) from student;
    5 : select sum(Marks) from student;
    6 : select AVG(Marks) from student;
    7 : select MAX(Marks) from student;
    8 : select MIN(Marks) from student;
    9 : select * from students where name = '____';
    10: update student set City = '____' where Rno = '____';
    11: delete from student where Rno = ____;
*/