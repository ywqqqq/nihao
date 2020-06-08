interface SortAlgorithm{
    public int[] sort(int[] array);
}

class Bubble implements SortAlgorithm{
    public int[] sort(int[] array){
        int temp;
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]>array[j-1]){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}

class Select implements SortAlgorithm{
    public int[] sort(int[] array){
        for(int i=0;i<array.length;i++){
            int k=i,temp;
            for(int j=i;j<array.length;j++){
                if(array[j]>array[k]) k=j;
            }
            temp=array[k];
            array[k]=array[i];
            array[i]=temp;
        }
        return array;
    }
}

class Insert implements SortAlgorithm{
    public int[] sort(int[] array){
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            int index=i-1;
            while(index>=0&&temp>array[index]){
                array[index+1]=array[index];
                index--;
            }
            array[index+1]=temp;
        }
        return array;
    }
}

class Handler{
    private SortAlgorithm sort;

    public void setSort(SortAlgorithm s){
        this.sort=s;
    }

    public int[] sort(int[] array){
        sort.sort(array);
        return array;
    }
}

public class StrategySort{
    public static void main(String[] args){
        int[] a=new int[]{5,6,2,1,12};
        int[] b;
        Handler handler=new Handler();
        SortAlgorithm sort;
        sort=new Bubble();
        handler.setSort(sort);
        b=handler.sort(a);
        for(int d:a){
            System.out.print(d+"\t");
        }
        System.out.print("\n");
        sort=new Insert();
        handler.setSort(sort);
        b=handler.sort(a);
        for(int d:a){
            System.out.print(d+"\t");
        }
        System.out.print("\n");

        sort=new Select();
        handler.setSort(sort);
        b=handler.sort(a);
        for(int d:a){
            System.out.print(d+"\t");
        }
        System.out.print("\n");

        
    }
}