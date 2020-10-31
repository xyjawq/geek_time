package com.xyjawq.learn.algorithm.queue;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**实现一种猫狗队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中
 * 用户可以调用pollAll方法，将队列所有的实例按照队列的先后顺序依次弹出
 * 用户可以调用pollDog 方法，将队列中dog类的实例按照队列的先后顺序依次弹出
 * 用户可以调用pollCat 方法，将队列中cat类的实例按照队列的先后顺序依次弹出
 * 用户可以调用isEmpty 方法，检查队列中是否还有dog或cat的实例
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
* @author: xyjawq
* @date: 2020/10/31
**/
public class CatDogQueue {

    @Getter
    @Setter
    public class Pet{
        /**
         * 队列顺序的前置宠物
         */
        private Pet pre;

        /**
         * 队列顺序的后置宠物
         */
        private Pet next;

        /**
         * 宠物类型
         */
        private String type;

        public Pet(String type) {
            this.type = type;
        }
    }

    @Getter
    @Setter
    public class Dog extends Pet{
        /**
         * 队列顺序的前置狗
         */
        private Dog dogPre;

        /**
         * 队列顺序的后置狗
         */
        private Dog dogNext;

        public Dog() {
            super("dog");
        }
    }

    @Getter
    @Setter
    public class Cat extends Pet{
        /**
         * 队列顺序的前置猫
         */
        private Cat catPre;

        /**
         * 队列顺序的后置猫
         */
        private Cat catNext;
        public Cat() {
            super("cat");
        }
    }

    /**
     * 队列头
     */
    private Pet head;
    /**
     * 队列尾
     */
    private Pet tail;

    /**
     * 狗队列头
     */
    private Dog dogHead;
    /**
     * 狗队列尾
     */
    private Dog dogTail;

    /**
     * 猫队列头
     */
    private Cat catHead;
    /**
     * 猫队列尾
     */
    private Cat catTail;

    /**
     * 队列大小
     */
    private long count;

    /**
     * 狗队列大小
     */
    private long dogCount;

    /**
     * 猫队列大小
     */
    private long catCount;

    public void add(Pet pet) {
        if (null == head) {
            head = pet;
        }
        if (null == tail) {
            tail = pet;
        }
        tail.next = pet;
        pet.pre = tail;
        tail = pet;
        count ++;
        if ("dog".equals(pet.getType())){
            Dog dog = (Dog)pet;
            if (null == dogHead) {
                dogHead = dog;
            }
            if (null == dogTail) {
                dogTail = dog;
            }
            dogTail.dogNext = dog;
            dog.dogPre = dogTail;
            dogTail = dog;
            dogCount ++;
        } else if ("cat".equals(pet.getType())){
            Cat cat = (Cat) pet;
            if (null == catHead) {
                catHead = cat;
            }
            if (null == catTail) {
                catTail = cat;
            }
            catTail.catNext = cat;
            cat.catPre = catTail;
            catTail = cat;
            catCount ++;
        } else {
            throw new RuntimeException("无效的宠物类型");
        }
    }

    public Pet poll() {
        if (isEmpty()) {
            return null;
        }
        Pet res = new Pet(tail.getType());
        tail = tail.pre;
        count--;
        if ("dog".equals(res.getType())) {
            dogCount--;
        } else if ("cat".equals(res.getType())) {
            catCount--;
        } else {
            throw new RuntimeException("无效的宠物类型");
        }
        return res;
    }

    public void pollAll() {
        while (!isEmpty()) {
            Pet pet = poll();
            System.out.println(pet.getType());
        }
    }

    public Dog pollDog() {
        if (isDogEmpty()) {
            return null;
        }
        Dog res = new Dog();
        res.setType(dogTail.getType());
        dogTail = dogTail.dogPre;
        dogCount--;
        return res;
    }

    public Cat pollCat() {
        if (isCatEmpty()) {
            return null;
        }
        Cat res = new Cat();
        res.setType(catTail.getType());
        catTail = catTail.catPre;
        catCount--;
        return res;
    }

    public boolean isEmpty() {
        return count > 0;
    }

    public boolean isDogEmpty() {
        return dogCount > 0;
    }

    public boolean isCatEmpty() {
        return catCount > 0;
    }

    public static void main(String[] args) {

    }
}
