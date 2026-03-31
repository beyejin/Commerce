import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상품 목록 생성
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 8));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 15));

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

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
            System.out.println();
            System.out.println("커머스 플랫폼을 종료합니다.");
        } else if (choice >= 1 && choice <= products.size()) {
            Product selected = products.get(choice - 1);

            System.out.println();
            System.out.println("[ 선택한 상품 정보 ]");
            System.out.println("상품명: " + selected.getName());
            System.out.println("가격: " + numberFormat.format(selected.getPrice()) + "원");
            System.out.println("설명: " + selected.getDescription());
            System.out.println("재고수량: " + selected.getStock() + "개");
        } else {
            System.out.println();
            System.out.println("올바른 번호를 입력해주세요.");
        }

        scanner.close();
    }
}