import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    //속성
    private List<Product> products;
    private Scanner scanner;
    private DecimalFormat df;

    //생성자
    public CommerceSystem(List<Product> products) {
        this.products = products;
        this.scanner = new Scanner(System.in);
        this.df = new DecimalFormat("#,###");
    }


    //기능
    public void start() {
        while (true) {
            printProductList();
            System.out.print("번호를 입력하세요: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println();
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            if (choice >= 1 && choice <= products.size()) {
                Product selectedProduct = products.get(choice - 1);
                System.out.println();
                System.out.println("[ 선택한 상품 정보 ]");
                System.out.println("상품명: " + selectedProduct.getName());
                System.out.println("가격: " + df.format(selectedProduct.getPrice()) + "원");
                System.out.println("설명: " + selectedProduct.getDescription());
                System.out.println("재고수량: " + selectedProduct.getStock());
                System.out.println();
            } else {
                System.out.println();
                System.out.println("올바른 번호를 입력해주세요.");
                System.out.println();
            }
        }
    }

    private void printProductList() {
        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %-15s | %10s원 | %s%n",
                    i + 1,
                    product.getName(),
                    df.format(product.getPrice()),
                    product.getDescription());
        }

        System.out.println("0. 종료             | 프로그램 종료");
    }
}
