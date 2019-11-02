import java.util.Objects;
import java.lang.Object;
import java.lang.String;


interface AnimalTypes {
    static final String WILD = "wild";
    static final String UNKNOWN = "unknown";
    static final String DOMESTIC = "domestic";
}

public class IntelligentSwitchStatement implements AnimalTypes {

    // Main
    public static void main(final String... doYourBest) {
        System.out.format( "\n\t\b\bVERSION A\n+-------------------+\n" );
        System.out.format( "   %s\n" , exampleOfSwitch_A("DOG") );
        System.out.format( "   %s\n" , exampleOfSwitch_A("CAT") );
        System.out.format( "   %s\n" , exampleOfSwitch_A("TIGER") );
        System.out.format( "   %s\n" , exampleOfSwitch_A("PANDA") );
        System.out.format( "\n\t\b\bVERSION B\n+-------------------+\n" );
        System.out.format( "   %s\n" , exampleOfSwitch_B("DOG") );
        System.out.format( "   %s\n" , exampleOfSwitch_B("CAT") );
        System.out.format( "   %s\n" , exampleOfSwitch_B("ELEPHANT") );
        System.out.format( "   %s\n\n" , exampleOfSwitch_B("PANDA") );
    }

    /** Version A: With the grouping of two case statements.
     *
     *  @param animal: the animal to verify its type
     *  @require animal be not null
     *  @return a concatenated string with the type of the animal:
     *          "domestic" | "wild" | "unknown"
     *  @access public
     */
    public static String exampleOfSwitch_A(String animal) {

        String animalType;

        // Verify that the animal Object is not null
        Objects.requireNonNull(animal);

        switch (animal) {
            case "DOG":
            case "CAT":
                animalType = "domestic";
                break;
            case "TIGER":
                animalType = "wild";
                break;
            default:
                animalType = "unknown";
                break;
        }
        return animal + ": " + animalType + " animal";
    }


    /** Version B: With the use of the conditional operator (?:)
     *  and a swith statement.
     *
     *  @param animal: the animal to verify its type
     *  @require animal be not null
     *  @return a concatenated string with the type of the animal:
     *          "domestic" | "wild" | "unknown"
     *  @access public
     */
    public static String exampleOfSwitch_B(String animal) {

        // Verify that the animal Object is not null
        Objects.requireNonNull(animal);

        String animalType;
        String wildOrUnknownType = (animal.equals("TIGER") ? WILD : UNKNOWN);
        String resultType = (animal.equals("DOG") || animal.equals("CAT"))
                                  ? DOMESTIC
                                  : wildOrUnknownType;

        switch(resultType) {
            case DOMESTIC:
            case WILD:
                animalType = resultType;
                break;
            default:
                resultType = UNKNOWN;
                animalType = resultType;
                break;
        }

        return animal + ": " + animalType + " animal";
    }

}
