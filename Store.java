/* 
* Purpose: print different products at a store, sorting in differnt orders, using various sorting methods
* Author: Madeline Vande Hey
* Date: 4/26/22
*/
public class Store{
    public static void main(String args[]){
        Product[] products = new Product[10];
        products[0] = new Product("Pink Skirt", 1245, 14.99, 5);
        products[1] = new Product("Green Top", 3478, 19.99, 10);
        products[2] = new Product("Bucket Hat", 2965, 16.99, 15);
        products[3] = new Product("Black Skirt", 8765, 9.99, 17);
        products[4] = new Product("Blue Pants", 7628, 24.99, 2);
        products[5] = new Product("Ripped Jeans", 9081, 14.99, 9);
        products[6] = new Product("Black Sneakers", 1177, 54.99, 4);
        products[7] = new Product("Brown Belt", 5290, 12.99, 10);
        products[8] = new Product("White Sweater", 5601, 34.99, 6);
        products[9] = new Product("Red Scarf", 4072, 4.99, 12);

        // print normal
        System.out.println("Store Products:\n");
        print(products);

        // print by number
        System.out.println("\n Insertion Sort by Number:\n");
        insertionProductNum(products);
        System.out.println("\n Selection Sort by Number:\n");
        selectionProductNum(products);
        System.out.println("\n Merge Sort by Number:\n");
        mergeSortNum(products, 0, products.length - 1);
        print(products);

        // print by name
        System.out.println("\n Insertion Sort by Name:\n");
        insertionName(products);
        System.out.println("\n Selection Sort by Name:\n");
        selectionName(products);
        System.out.println("\n Merge Sort by Name:\n");
        mergeSortName(products, 0, products.length - 1);
        print(products);

        // print by price
        System.out.println("\n Insertion Sort by Price [ low to high ]:\n");
        insertionPrice(products);
        System.out.println("\n Selection Sort by Price [ low to high ]:\n");
        selectionPrice(products);
        System.out.println("\n Merge Sort by Price [ low to high ]:\n");
        mergeSortPrice(products, 0, products.length - 1);
        print(products);

        // print by quantity
        System.out.println("\n Insertion Sort by Quantity:\n");
        insertionQuantity(products);
        System.out.println("\n Selection Sort by Quantity:\n");
        selectionQuantity(products);
        System.out.println("\n Merge Sort by Quantity:\n");
        mergeSortQuantity(products, 0, products.length - 1);
        print(products);

    }

    // Design a static method that traverses through the array and prints each element in a table format.
    public static void print(Product[] products){
        System.out.printf("%s %20s %15s %15s", "Name", "#", "Price", "Quantity\n");
        System.out.println("---------------------------------------------------------");
        for(Product p : products){
            System.out.println(p.toString());
        }
    }

    // Using each sorting algorithm at least once, you may choose when to employ the insertion, selection, or merge sort.
    

    // a method that sorts the array by the product number
    // insertion
    public static void insertionProductNum(Product[] source){
        Product[] dest = new Product[ source.length ];

        for(int i = 0 ; i < source.length ; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;
            while(k > 0 && insertIndex == 0){
                if(next.getNum() - dest[k-1].getNum() > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
        }
        
        print(dest);
    }

    // selection
    public static void selectionProductNum(Product[] source){
        Product[] dest = new Product[source.length];
        for(int i = 0; i < source.length; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;

            while(k > 0 && insertIndex == 0){
                if(next.getNum() > dest[k - 1].getNum()) insertIndex = k;
                else dest[ k ] = dest[ k - 1 ];
                k--;
            }

            dest[ insertIndex ] = next;
        }
            print(dest);
    }

    // merge sort
    public static void mergeSortNum(Product[] a, int low, int high){
        if(low == high) return;

        int mid = (low + high) / 2;

        mergeSortNum(a, low, mid);
        mergeSortNum(a, mid + 1, high);

        mergeNum(a, low, mid, high);
    }

    public static void mergeNum(Product[] a, int low, int mid, int high ){
        Product[] temp = new Product[high - low + 1];

        int i = low, j = mid + 1, n = 0;

        while(i <= mid || j <= high){
            if(i > mid){
                temp[ n ] = a[ j ];
                j++;
            }
            else if(j > high){
                temp[ n ] = a[ i ];
                i++;
            }
            else if(a[i].getNum() < a[j].getNum()){
                temp[ n ] = a[ i ];
                i++;
            }
            else{
                temp[n] = a[j];
                j++;
            }
            n++;
        }

        for(int k = low ; k <= high ; k++){
            a[k] = temp[ k - low ];
        }
    }

    // a method that sorts the array by the product's name
    // insertion
    public static void insertionName(Product[] source){
        Product[] dest = new Product[source.length];

        for( int i = 0 ; i < source.length ; i++ ){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;
            while(k > 0 && insertIndex == 0){
                if(next.getName().compareTo(dest[k-1].getName()) > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
        }
        
        print(dest);
    }

    // selection
    public static void selectionName(Product[] source){
        Product[] dest = new Product[source.length];

        for(int i = 0 ; i < source.length ; i++ ){
            Product next = source[ i ];
            int insertIndex = 0;
            int k = i;

            while(k > 0 && insertIndex == 0){
                if(next.getName().compareTo(dest[k-1].getName()) > 0) insertIndex = k;
                else dest[k] = dest[k - 1];
                k--;
            }

            dest[insertIndex] = next;
        }

        print(dest);
    }

    // merge sort
    public static void mergeSortName(Product[] a, int low, int high){
        if(low == high) return;

        int mid = (low + high) / 2;

        mergeSortName(a, low, mid);
        mergeSortName(a, mid + 1, high);

        mergeName(a, low, mid, high);
    }

    public static void mergeName(Product[] a, int low, int mid, int high){
        Product[] products = new Product[high - low + 1];

        int i = low, j = mid + 1, n = 0;

        while(i <= mid || j <= high){
            if(i > mid){
                products[n] = a[j];
                j++;
            }
            else if(j > high){
                products[n] = a[i];
                i++;
            }
            else if(a[i].getName().compareTo(a[j].getName()) < 0){
                products[n] = a[i];
                i++;
            }
            else{
                products[n] = a[j];
                j++;
            }
            n++;
        }

        for(int k = low ; k <= high ; k++){
            a[k] = products[k - low];
        }
    }

    // a method that sorts the array by the item's price
    // insertion
    public static void insertionPrice(Product[] source){
        Product[] dest = new Product[source.length];

        for(int i = 0 ; i < source.length ; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;
            while(k > 0 && insertIndex == 0){
                if(next.getPrice() - dest[k-1].getPrice() > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
        }
        
        print(dest);
    }

    // selection
    public static void selectionPrice(Product[] source){
        Product[] dest = new Product[source.length];
        for(int i = 0; i < source.length; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;

            while(k > 0 && insertIndex == 0){
                if(next.getPrice() > dest[k - 1].getPrice()) insertIndex = k;
                else dest[ k ] = dest[ k - 1 ];
                k--;
            }

            dest[ insertIndex ] = next;
        }
            print(dest);
    }

    // merge sort
    public static void mergeSortPrice(Product[] a, int low, int high ){
        if(low == high) return;

        int mid = (low + high) / 2;

        mergeSortPrice(a, low, mid);
        mergeSortPrice(a, mid + 1, high);

        mergePrice(a, low, mid, high);
    }

    public static void mergePrice(Product[] a, int low, int mid, int high ){
        Product[] temp = new Product[high - low + 1];

        int i = low, j = mid + 1, n = 0;

        while(i <= mid || j <= high){
            if(i > mid){
                temp[ n ] = a[ j ];
                j++;
            }
            else if(j > high){
                temp[ n ] = a[ i ];
                i++;
            }
            else if(a[i].getPrice() < a[j].getPrice()){
                temp[ n ] = a[ i ];
                i++;
            }
            else{
                temp[n] = a[j];
                j++;
            }
            n++;
        }

        for(int k = low ; k <= high ; k++){
            a[k] = temp[ k - low ];
        }
    }

    // a method that sorts the array by the product quantity
    // insertion
    public static void insertionQuantity(Product[] source){
        Product[] dest = new Product[source.length];

        for(int i = 0 ; i < source.length ; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;
            while(k > 0 && insertIndex == 0){
                if(next.getQuantity() - dest[k-1].getQuantity() > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
        }
        
        print(dest);
    }

    // selection
    public static void selectionQuantity(Product[] source){
        Product[] dest = new Product[source.length];
        for(int i = 0; i < source.length; i++){
            Product next = source[i];
            int insertIndex = 0;
            int k = i;

            while(k > 0 && insertIndex == 0){
                if(next.getQuantity() > dest[k - 1].getQuantity()) insertIndex = k;
                else dest[ k ] = dest[ k - 1 ];
                k--;
            }

            dest[ insertIndex ] = next;
        }
            print(dest);
    }

    // merge sort
    public static void mergeSortQuantity(Product[] a, int low, int high ){
        if(low == high) return;

        int mid = (low + high) / 2;

        mergeSortQuantity(a, low, mid);
        mergeSortQuantity(a, mid + 1, high);

        mergeQuantity(a, low, mid, high);
    }

    public static void mergeQuantity(Product[] a, int low, int mid, int high ){
        Product[] temp = new Product[high - low + 1];

        int i = low, j = mid + 1, n = 0;

        while(i <= mid || j <= high){
            if(i > mid){
                temp[ n ] = a[ j ];
                j++;
            }
            else if(j > high){
                temp[ n ] = a[ i ];
                i++;
            }
            else if(a[i].getQuantity() < a[j].getQuantity()){
                temp[ n ] = a[ i ];
                i++;
            }
            else{
                temp[n] = a[j];
                j++;
            }
            n++;
        }

        for(int k = low ; k <= high ; k++){
            a[k] = temp[ k - low ];
        }
    }
}