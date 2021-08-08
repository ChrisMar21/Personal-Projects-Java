public class Student{
    private String firstName;
    private String lastName;
    private String fullName;
    private String userName;
    private String password;
    
    /**
     * 
     */
    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.fullName = "";
        this.userName = "";
        this.password = "";
    }
    /**
     * 
     * @param firstName
     * @param lastName
     * @param userName
     * @param password 
     */
    public Student(String firstName,String lastName,String userName,
                   String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    /**
     * 
     * @param lastName 
     */
    public void setLastName(String lastName){
        this.lastName = lastName;      
    }
    /**
     * 
     * @param userName 
     */
    public void setUsername(String userName){
        this.userName = userName;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword(String password){
        this.password = password; 
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getFullName(){
        return this.firstName + " " +  this.lastName;
    }
    public String getUsername(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
}