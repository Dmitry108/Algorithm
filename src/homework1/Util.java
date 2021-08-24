package homework1;
//другие виды сортировок

public class Util {
//    private static int iterationCounter;
//
//    private static long bubbleSortNotebook(Notebook[] notebooks){
//        boolean isChange;
//        iterationCounter = 0;
//        long time = System.currentTimeMillis();
//        do {
//            isChange = false;
//            for (int i = 0; i < notebooks.length - 1; i++){
//                if (Notebook.compare(notebooks[i], notebooks[i+1]) > 0){
//                    changeElementsInArray(notebooks, i, i+1);
//                    isChange = true;
//                }
//                iterationCounter++;
//            }
//        } while (isChange);
//        return System.currentTimeMillis() - time;
//    }
//
//    private static long cocktailSortNotebook(Notebook[] notebooks) {
//        boolean isChange;
//        iterationCounter = 0;
//        long time = System.currentTimeMillis();
//        do {
//            isChange = false;
//            for (int i = 0; i <= notebooks.length - 2; i++) {
//                if (Notebook.compare(notebooks[i], notebooks[i + 1]) > 0) {
//                    changeElementsInArray(notebooks, i, i + 1);
//                    isChange = true;
//                    iterationCounter++;
//                }
//            }
//            if (!isChange) {
//                break;
//            }
//            isChange = false;
//            for (int i = notebooks.length - 2; i >= 0; i--) {
//                if (Notebook.compare(notebooks[i], notebooks[i + 1]) > 0) {
//                    changeElementsInArray(notebooks, i, i+1);
//                    isChange = true;
//                    iterationCounter++;
//                }
//            }
//        } while (isChange);
//        return System.currentTimeMillis() - time;
//    }
//
//
//
//    private static long selectionSortNotebook (Notebook[] notebooks){
//        int min;
//        iterationCounter = 0;
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < notebooks.length - 1; i++){
//            min = i;
//            for (int j = i+1; j < notebooks.length; j++) {
//                if (Notebook.compare(notebooks[min], notebooks[j]) > 0) {
//                    min = j;
//                }
//                iterationCounter++;
//            }
//            if (min != i) {
//                changeElementsInArray(notebooks, i, min);
//            }
//        }
//        return System.currentTimeMillis() - time;
//    }
//
//    private static long improveSelectionSortNotebook (Notebook[] notebooks){
//        int min;
//        int max;
//        int n = notebooks.length;
//        iterationCounter = 0;
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < n - 1; i++){
//            min = i;
//            max = i;
//            for (int j = i+1; j < n; j++) {
//                if (Notebook.compare(notebooks[min], notebooks[j]) > 0) {
//                    min = j;
//                }
//                if (Notebook.compare(notebooks[max], notebooks[j]) < 0) {
//                    max = j;
//                }
//                iterationCounter++;
//            }
//            if (min != i) {
//                changeElementsInArray(notebooks, i, min);
//            }
//            if (max != i) {
//                changeElementsInArray(notebooks, n-1, max);
//            }
//            n--;
//        }
//        return System.currentTimeMillis() - time;
//    }
//
//    private static long insertionSortNotebook(Notebook[] notebooks) {
//        int n = notebooks.length;
//        iterationCounter = 0;
//        Notebook notebook;
//        long time = System.currentTimeMillis();
//        for (int i = 1; i < n; i++) {
//            notebook = notebooks[i];
//            int j = i - 1;
//            while (j >= 0 && Notebook.compare(notebooks[j], notebook) > 0) {
//                notebooks[j+1] = notebooks[j];
//                j--;
//                iterationCounter++;
//            }
//            notebooks[j+1] = notebook;
//        }
//        return System.currentTimeMillis() - time;
//    }
//
//    private static void changeElementsInArray(Object[] objects, int index1, int index2){
//        Object object = objects[index1];
//        objects[index1] = objects[index2];
//        objects[index2] = object;
//    }
}