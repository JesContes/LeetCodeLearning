package com.company.leetcode1670;

/**
 * @author awmlk
 */
public class FrontMiddleBackQueue {
    private static class FrontMiddleBackNode {
        int val;
        FrontMiddleBackNode pre;
        FrontMiddleBackNode next;
    }

    /**
     * 节点数量
     */
    private int num;

    /**
     * 头节点
     */
    private FrontMiddleBackNode head;

    /**
     * 中间节点
     */
    private FrontMiddleBackNode mid;

    /**
     * 尾节点
     */
    private FrontMiddleBackNode back;

    public FrontMiddleBackQueue() {
        num = 0;
        head = null;
        mid = null;
        back = null;
    }

    private boolean isPureMid() {
        return num % 2 == 1;
    }

    public void pushFront(int val) {
        FrontMiddleBackNode node = new FrontMiddleBackNode();
        node.val = val;
        if (num == 0) {
            head = node;
            mid = node;
            back = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
            if (isPureMid()) {
                mid = mid.pre;
            }
        }
        num++;
    }

    public void pushMiddle(int val) {
        FrontMiddleBackNode node = new FrontMiddleBackNode();
        node.val = val;
        if (num == 0) {
            head = node;
            mid = node;
            back = node;
        } else {
            if (isPureMid()) {
                node.pre = mid.pre;
                if (node.pre != null) {
                    node.pre.next = node;
                } else {
                    head = node;
                }
                node.next = mid;
                mid.pre = node;
                mid = node;
            } else {
                node.next = mid.next;
                if (node.next != null) {
                    node.next.pre = node;
                }
                node.pre = mid;
                mid.next = node;
                mid = node;
            }
        }
        num++;
    }

    public void pushBack(int val) {
        FrontMiddleBackNode node = new FrontMiddleBackNode();
        node.val = val;
        if (num == 0) {
            head = node;
            mid = node;
            back = node;
        } else {
            back.next = node;
            node.pre = back;
            back = node;
            if (!isPureMid()) {
                mid = mid.next;
            }
        }
        num++;
    }

    public int popFront() {
        if (num == 0) {
            return -1;
        }
        int result = head.val;
        head = head.next;
        if (head != null) {
            head.pre = null;
        }
        if (!isPureMid()) {
            mid = mid.next;
        }
        num--;
        return result;
    }

    public int popMiddle() {
        if (num == 0) {
            return -1;
        }
        int result = mid.val;
        if (mid.next != null) {
            mid.next.pre = mid.pre;
        }
        if (mid.pre != null) {
            mid.pre.next = mid.next;
        } else {
            head = head.next;
        }
        if (isPureMid()) {
            mid = mid.pre;
        } else {
            mid = mid.next;
        }
        num--;
        return result;
    }

    public int popBack() {
        if (num == 0) {
            return -1;
        }
        int result = back.val;
        back = back.pre;
        if (back != null) {
            back.next = null;
        }
        if (isPureMid()) {
            mid = mid.pre;
        }
        num--;
        return result;
    }
}
