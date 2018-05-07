package com.dp.study;

public class PersonForTest {
		private String name ;
		private Integer  sex;
		private Double money;
		
		public PersonForTest(String name, Integer sex, Double money) {
			super();
			this.name = name;
			this.sex = sex;
			this.money = money;
			System.out.println("构造：Person");
		}

		public PersonForTest() {
			super();
			System.out.println("构造：PersonSuper");
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			System.out.println("getName");
			return name;
		}

		public void setName(String name) {
			System.out.println("setName");
			this.name = name;
		}

		public Integer getSex() {
			return sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		public Double getMoney() {
			return money;
		}

		public void setMoney(Double money) {
			this.money = money;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((money == null) ? 0 : money.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((sex == null) ? 0 : sex.hashCode());
			return result;
		}


		@Override
		public String toString() {
			return "Person [name=" + name + ", sex=" + sex + ", money=" + money + "]";
		}
		
		
		
}
