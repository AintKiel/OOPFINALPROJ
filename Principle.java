import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

// Abstract class for common applicant functionality  (ENCAPSULATION)
abstract class Applicant {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;

    // Constructor (ENCAPSULATION)
    public Applicant(String firstName, String middleName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Abstract method to display applicant details
    public abstract void displayDetails();

    // Age calculation
    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Full name   (ENCAPSULATION)
    public String getFullName() {
        return firstName + (middleName.isEmpty() ? "" : " " + middleName) + " " + lastName;
    }
}

// Class for Scholarship Applicant
class ScholarshipApplicant extends Applicant {
    private String gender;
    private String nationality;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String email;
    private String educationLevel;
    private String academicInstitution;
    private String extracurriculars;

    // Constructor
    public ScholarshipApplicant(String firstName, String middleName, String lastName, LocalDate birthDate,
                                String gender, String nationality, String country, String state,
                                String city, String postalCode, String email, String educationLevel,
                                String academicInstitution, String extracurriculars) {
        super(firstName, middleName, lastName, birthDate);
        this.gender = gender;
        this.nationality = nationality;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.educationLevel = educationLevel;
        this.academicInstitution = academicInstitution;
        this.extracurriculars = extracurriculars;
    }

    // Implement the abstract method to display applicant details
    @Override
    public void displayDetails() {
        System.out.println("\n=== Applicant Information ===");
        System.out.println("Full Name: " + getFullName());
        System.out.println("Age: " + calculateAge());
        System.out.println("Gender: " + gender);
        System.out.println("Nationality: " + nationality);
        System.out.println("Address: " + city + ", " + state + ", " + country + " - " + postalCode);
        System.out.println("Email: " + email);
        System.out.println("Education Level: " + educationLevel);
        System.out.println("Academic Institution: " + academicInstitution);
        System.out.println("Extracurricular Activities: " + (extracurriculars.isEmpty() ? "None" : extracurriculars));
    }
}

// Main class to execute the program
public class Principle {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();
        if (!getUserAcceptance()) {
            System.out.println("You did not accept the terms. Application cannot proceed.");
            return;
        }
        ScholarshipApplicant applicant = gatherApplicantDetails();
        applicant.displayDetails();
    }

    // Display welcome message
    private static void displayWelcomeMessage() {
        String title = "SCHOLARGATE";
        String spacedText = title.replaceAll("(.)", "$1 ");
        String border = "*".repeat(spacedText.length() + 4);
        System.out.println(border);
        System.out.println("* " + spacedText + "*");
        System.out.println(border);
        displayScholarshipTerms();
    }

    // Display scholarship terms and conditions
    private static void displayScholarshipTerms() {
        System.out.println("\n=== Scholarship Terms and Conditions ===\n");
        String[] terms = {
            "1. Eligibility - Applicants must be full-time students at an accredited institution, meet GPA requirements, " +
    "\n         fulfill residency, and must be 16 and above.",
    
    "2. Application Requirements - Applications, including all required documents, must be complete and " +
    "\n         submitted by the deadline. By applying, applicants confirm that all provided information is accurate.",
    
    "3. Selection Process - Recipients are selected based on academic merit, financial need, or other stated " +
    "\n         criteria. All committee decisions are final.",
    
    "4. Award Conditions - Scholarship funds must be used for educational expenses and are non-transferable. " +
    "\n         Recipients must maintain the required GPA.",
    
    "5. Fund Disbursement - Funds are sent directly to the institution or as specified and may be disbursed " +
    "\n         in installments. Failure to meet academic standards may lead to termination of funds.",
    
    "6. Recipient Responsibilities - Recipients may be asked to participate in promotional activities and must " +
    "\n         report any changes in academic status. Misrepresentation or misconduct may lead to revocation.",
    
    "7. Privacy - Applicant information is used solely for scholarship administration and protected in line " +
    "\n         with privacy laws.",
    
    "8. Acceptance - \"I have read and understood the scholarship terms and conditions outlined in the application. " +
    "\n         I agree to abide by all requirements and responsibilities associated with this scholarship, including " +
    "\n         maintaining the required GPA and using the funds for educational purposes only.\""
    };
        
        for (String term : terms) {
            System.out.println(term);
        }
    }

    // Get user acceptance for the terms
    private static boolean getUserAcceptance() {
        while (true) {
            System.out.print("\nDo you accept these terms? (Y/N): ");
            char agree = scanner.nextLine().toLowerCase().charAt(0);

            switch (agree) {
                case 'y':
                    System.out.println("\nThank you for accepting the terms.");
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
            }
        }
    }

    // Gather applicant details and create a ScholarshipApplicant object
    private static ScholarshipApplicant gatherApplicantDetails() {
        System.out.print("\n\nEnter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your middle name (or press Enter to skip): ");
        String middleName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        LocalDate birthDate = getBirthDate();

        System.out.print("Enter your gender (M/F/Other): ");
        String gender = scanner.nextLine();
        System.out.print("Enter your nationality: ");
        String nationality = scanner.nextLine();
        System.out.print("Enter your residential country: ");
        String country = scanner.nextLine();
        System.out.print("Enter your state/province: ");
        String state = scanner.nextLine();
        System.out.print("Enter your city: ");
        String city = scanner.nextLine();
        System.out.print("Enter your postal code: ");
        String postalCode = scanner.nextLine();
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your education level (High School, College, Graduate): ");
        String educationLevel = scanner.nextLine();
        System.out.print("Enter your current academic institution: ");
        String academicInstitution = scanner.nextLine();
        System.out.print("Enter your extracurricular activities (or press Enter to skip): ");
        String extracurriculars = scanner.nextLine();

        return new ScholarshipApplicant(firstName, middleName, lastName, birthDate,
                                        gender, nationality, country, state, city,
                                        postalCode, email, educationLevel, academicInstitution,
                                        extracurriculars);
    }

    // Get birth date from user input
    private static LocalDate getBirthDate() {
        while (true) {
            try {
                System.out.print("Enter your birthdate (YYYY-MM-DD): ");
                String birthDateInput = scanner.nextLine();
                return LocalDate.parse(birthDateInput);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }
}
