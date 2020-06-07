package com.structural.facade2;

class CPU {
	public void freeze() { System.out.println("freeze"); }
	public void jump(long position) { System.out.println("jump");}
	public void execute() { System.out.println("executing");}
}
 
class Memory {
	public void load(long position, byte[] data) {
		System.out.println("load in memory");
	}
}
 
class HardDrive {
   byte data[] = new byte[30];
   
	public byte[] read(long lba, int size) {
		System.out.println("reading HDD");
		return data;
		
	}
}
 
/* Facade */
 
class Computer {
     HardDrive hardDrive = new HardDrive();
	 Memory memory = new Memory();
	 CPU cpu = new CPU();
	 int BOOT_ADDRESS =1;
	 int SECTOR_SIZE = 2;
	 int BOOT_SECTOR=3;
	public void startComputer() {
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}
 
/* Client */
 
public class FacadeDemo {
	public static void main(String[] args) {
		Computer facade = new Computer();
		facade.startComputer();
	}
}