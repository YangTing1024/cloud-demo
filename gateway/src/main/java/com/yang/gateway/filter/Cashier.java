package com.yang.gateway.filter;

/*
 * @Description: TODO
 * @Author: YangTing
 * @Date: 2025/10/30 下午9:42
 **/
import java.util.Scanner;

public class Cashier {
    public static void main(String[] args) {
        // 步骤二：读取控制台输入
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入商品单价（元）：");
        double unitPrice = scanner.nextDouble(); // 商品单价

        System.out.print("请输入购买数量：");
        double quantity = scanner.nextDouble(); // 购买数量（题目要求用nextDouble()）

        System.out.print("请输入收款金额（元）：");
        double receivedAmount = scanner.nextDouble(); // 收款金额

        scanner.close(); // 关闭Scanner，释放资源

        // 步骤三：计算总价及折扣（用if-else语句）
        double total = unitPrice * quantity; // 1. 计算商品总价
        double payableAmount; // 折后应收金额（需判断折扣）

        // 2. 用if-else判断是否打八折（总价≥500）
        if (total >= 500) {
            payableAmount = total * 0.8; // 打八折（总价×0.8）
        } else {
            payableAmount = total; // 不打折（保持原价）
        }

        // 步骤四：计算找零及输出结果
        double change = receivedAmount - payableAmount; // 1. 计算找零（收款金额-应收金额）

        // 2. 输出结果（保留2位小数，符合货币格式）
        System.out.println("=== 结算结果 ===");
        System.out.printf("商品总价：%.2f元%n", total);
        System.out.printf("折后应收金额：%.2f元%n", payableAmount);
        System.out.printf("收款金额：%.2f元%n", receivedAmount);
        System.out.printf("找零金额：%.2f元%n", change);
    }
}