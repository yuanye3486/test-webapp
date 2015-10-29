package com.fengqiliu.test.hightqualitycode.item6_06.com.company.section3;

public class Client {
	public static void main(String[] args) {
		Car car = CarFactory.BuickCar.create();
	}
}

interface Car {
};

class FordCar implements Car {
};

class BuickCar implements Car {
};

enum CarFactory {
	FordCar {
		public Car create() {
			return new FordCar();
		}
	},
	BuickCar {
		public Car create() {
			return new BuickCar();
		}
	};
	//抽象生产方法
	public abstract Car create();
}