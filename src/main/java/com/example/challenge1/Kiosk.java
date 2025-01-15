package com.example.challenge1;

import com.example.challenge1.Menu;

import java.util.List;
import java.util.Scanner;

//메뉴 관리 및 사용자 입력 처리
public class Kiosk {

    private final Cart cart = new Cart();

    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }


    //메뉴 입력 및 반복문
    public void start() {
        //Scanner 선언
        Scanner scanner = new Scanner(System.in);
        //반복문 탈출 flag 선언
        boolean exit = false;


        while (!exit) {
            //장바구니에 물건이 있는 경우
            boolean notEmpty = false;

            System.out.println("\n[ MAIN MENU ]");

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + 1 + ". " + menuList.get(i).getCategoryName());
            }
            System.out.println("0. 종료 | 종료");

            //장바구니에 물건이 있는 경우
            if (!cart.getCartList().isEmpty()) {
                notEmpty = true;
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(menuList.size() + 1 + ". Orders      | 장바구니를 확인 후 주문합니다.");
                System.out.println(menuList.size() + 2 + ". Cancel      | 진행중인 주문을 취소합니다.");
            }


            //메뉴 숫자 입력 받기. 코드 반복을 줄이기 위해 if else로 수정
            System.out.print("메뉴의 숫자를 입력해주세요: ");
            try {
                int selectMenuNum = scanner.nextInt();
                if (selectMenuNum == 0) {
                    exit = true;
                    System.out.println("프로그램을 종료합니다.");
                } else if (selectMenuNum > 0 && selectMenuNum <= menuList.size()) {

                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    Menu selectedMenu = menuList.get(selectMenuNum - 1);

                    System.out.println("\n[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");

                    //Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                    selectedMenu.showMenuItem();

                    //아이템 숫자 입력 받기
                    System.out.print("메뉴의 숫자를 입력해주세요: ");

                    try {
                        int selectItemNum = scanner.nextInt();
                        if (selectItemNum == 0) {
                            //뒤로가기
                            continue;
                        } else if (selectItemNum > 0 && selectItemNum <= selectedMenu.getMenuItems().size()) {
                            MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(selectItemNum - 1);
                            System.out.println("\n선택한 메뉴: " + selectedMenuItem);

                            //장바구니 관련 코드
                            System.out.println("\n" + selectedMenuItem);
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인       2. 취소");

                            //장바구니 추가
                            try {
                                int addCartInput = scanner.nextInt();
                                if (addCartInput == 1) {
                                    cart.addCart(selectedMenuItem);
                                    System.out.println("\n" + selectedMenuItem.getFoodName() + "이(가) 장바구니에 추가되었습니다.");
                                } else if(addCartInput == 2) continue;
                                else throw new ArithmeticException("올바르지 않은 숫자입니다.");
                            } catch (Exception e) {
                                System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                                scanner.next();
                            }
                        } else {
                            System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
                        }
                    } catch (Exception e) {
                        System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                        scanner.next();
                    }
                    System.out.println();

                } else if (notEmpty && selectMenuNum == menuList.size() + 1) { //장바구니에 물건이 있고 주문을 선택한 경우
                    System.out.println("\n아래와 같이 주문하시겠습니까?");
                    System.out.println("\n[ Orders ]");
                    cart.showCartItem();
                    System.out.println("\n[ Total ]");
                    System.out.println(cart.calculatePrice() + "원");

                    System.out.println("\n1. 주문       2. 메뉴판");
                    int finalOrder = scanner.nextInt();
                    if (finalOrder == 1) {
                        System.out.println("주문이 완료되었습니다. 금액은 " + cart.calculatePrice() + "원 입니다.");
                        cart.resetCartList(); // 주문 후 장바구니 초기화
                    } else if (finalOrder == 2) continue;
                    else System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
                } else if (notEmpty && selectMenuNum == menuList.size() + 2) { //장바구니에 물건이 있고 취소를 선택한 경우
                    System.out.println("주문을 취소하면 장바구니 항목이 삭제됩니다. 취소하려면 1을 눌러주세요");
                    int resetListInput = scanner.nextInt();
                    if (resetListInput == 1) {
                        cart.resetCartList();
                        System.out.println("주문이 취소되었습니다.");
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    }
                } else {
                    System.out.println("\n잘못된 선택입니다. 다시 입력해 주세요.");
                }
            } catch (Exception e) {
                System.out.println("\n유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
                scanner.next();
            }
            System.out.println();
        }
    }
}
