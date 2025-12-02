class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;

        int currentTime = 0;
        for (int[] attack : attacks) {
            int gap = attack[0] - currentTime - 1;

            if (gap > 0) {
                health += bandage[1] * gap;

                health += (gap / bandage[0]) * bandage[2];

                if (health > maxHealth) {
                    health = maxHealth;
                }
            }

            health -= attack[1];
            if (health <= 0) {
                return -1;
            }

            currentTime = attack[0];
        }

        return health;
    }
}