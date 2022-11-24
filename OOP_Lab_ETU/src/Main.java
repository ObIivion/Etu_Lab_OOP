import factories.ArcherFactory;
import factories.CavalryFactory;
import factories.InfantryFactory;
import game.GameField;
import supportingFiles.CheckInputService;

public class Main {
    public static void main(String[] args) {

        gameMenu();
    }

    private static void gameMenu() {

        InfantryFactory infantryFactory = new InfantryFactory();
        ArcherFactory archerFactory = new ArcherFactory();
        CavalryFactory cavalryFactory = new CavalryFactory();

        startGameWrites();

        int height = CheckInputService.inputInteger(50, "Your height is too big. It will uncomfortable");
        int width = CheckInputService.inputInteger(50, "Your width is too big. It will uncomfortable");

        GameField gameField = new GameField(height, width);
        gameField.drawField();

        int choice = 0;
        while (choice != 4) {

            startMenuGame();

            choice = CheckInputService.inputInteger(4, "Your input is out of range (1 - 4)");
            switch (choice) {
                case 1:
                    System.out.println("Chose type of unit:");
                    System.out.println("1 - Infantry\n2 - Archer\n3 - Cavalry");
                    int subChoice = CheckInputService.inputInteger(4, "Your input is out of range (1 - 3)");
                    switch (subChoice) {
                        case 1:
                            System.out.println("Input type of Infantry");
                            System.out.println("1 - SwordsMan\n2 - SpearMan");
                            int typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                            switch (typeChoice) {
                                case 1:
                                    gameField.addUnit(infantryFactory.createUnit(InfantryFactory.InfantryTypes.swordsMan));
                                    break;
                                case 2:
                                    gameField.addUnit(infantryFactory.createUnit(InfantryFactory.InfantryTypes.spearMan));
                                    break;
                                default:
                                    System.out.println("Error of typeChoice");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Input type of Archer");
                            System.out.println("1 - LongArcher\n2 - ShortArcher");
                            typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                            switch (typeChoice) {
                                case 1:
                                    gameField.addUnit(archerFactory.createUnit(ArcherFactory.ArcherTypes.longArcher));
                                    break;
                                case 2:
                                    gameField.addUnit(archerFactory.createUnit(ArcherFactory.ArcherTypes.shortArcher));
                                    break;
                                default:
                                    System.out.println("Error of typeChoice");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Input type of Cavalry");
                            System.out.println("1 - ShootCavalry\n2 - AttackCavalry");
                            typeChoice = CheckInputService.inputInteger(2, "Your input is out of range (1 - 2)");
                            switch (typeChoice) {
                                case 1:
                                    gameField.addUnit(cavalryFactory.createUnit(CavalryFactory.CavalryTypes.shootCavalry));
                                    break;
                                case 2:
                                    gameField.addUnit(cavalryFactory.createUnit(CavalryFactory.CavalryTypes.attackCavalry));
                                    break;
                                default:
                                    System.out.println("Error of typeChoice");
                                    break;
                            }
                        default:
                            System.out.println("Error of typeChoice");
                    }
                    break;
                case 2:
                    gameField.deleteUnit();
                    break;
                case 3:
                    gameField.moveUnit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Error of Choice");
            }
        }
    }

    private static void startGameWrites() {

        System.out.println("Start game");
        System.out.println("Set height and width of field");
    }

    private static void startMenuGame() {

        System.out.println("MenuGame");
        System.out.println("Make your choice");
        System.out.println("1 - Add unit\n2 - Remove unit\n3 - Move unit \n4 - Escape from the battle");
    }
}