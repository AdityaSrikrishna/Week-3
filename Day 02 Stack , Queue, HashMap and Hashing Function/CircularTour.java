public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < pumps.length; i++) {
            int surplus = pumps[i].petrol - pumps[i].distance;
            totalSurplus += surplus;
            currentSurplus += surplus;

            if (currentSurplus < 0) {
                // Cannot start from current `start`, move to next pump
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int startIndex = findStartingPoint(pumps);
        System.out.println("Start at petrol pump: " + startIndex);
    }
}
