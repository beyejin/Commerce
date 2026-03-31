import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CommerceSystem {
    private List<Product> products;

    // 생성자를 통해 상품 목록을 전달받음
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    // main에서 하던 입력/반복문 로직을 여기서 관리
    public void start() {
        Scanner scanner = new Scanner(System.in);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 - 전자제품 ]");

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%d. %-15s | %,12d원 | %s%n",
                        i + 1,
                        p.getName(),
                        p.getPrice(),
                        p.getDescription());
            }

            System.out.println("0. 종료           | 프로그램 종료");
            System.out.print("번호를 입력하세요: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("\n커머스 플랫폼을 종료합니다.");
                break;
            } else if (choice >= 1 && choice <= products.size()) {
                Product selected = products.get(choice - 1);

                System.out.println("\n[ 선택한 상품 정보 ]");
                System.out.println("상품명: " + selected.getName());
                System.out.println("가격: " + numberFormat.format(selected.getPrice()) + "원");
                System.out.println("설명: " + selected.getDescription());
                System.out.println("재고수량: " + selected.getStock() + "개");
            } else {
                System.out.println("\n올바른 번호를 입력해주세요.");
            }
        }

        scanner.close();
    }
}