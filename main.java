package com.kjs.checkdia;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Checkdia extends JavaPlugin {
    @Override
    public void onEnable() {
    }
    
    
    @Override
    public void onDisable() {

    }
    
    public int getrannum() //���� �߻� �Լ�
    {
    	double firstrandom = 0;
    	int finalrandom = 0;
    	
    	firstrandom = Math.random();
    	finalrandom = (int)(firstrandom * 100) + 1;
    	
    	return finalrandom;
    }
    
    public int getpsb(int entlev)
    {
    	if(entlev < 4)
    	{
    		return 95;	
    	}
    	    	
    	if(entlev > 3 || entlev < 9)
    	{
    		return 85 - (10 * (entlev - 4));
    	}
    	
    	if(entlev == 9)
    	{
    	return 25;	
    	}
    	
    	if(entlev > 9)
    	{
    	return 5;	
    	}
    	
    	return 999;
    	
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		
		
		if(cmd.getName().equalsIgnoreCase("reinf")) //reinf��� ��ɾ ������...
		{
			//player.sendMessage("��ȭ�� �õ��մϴ�..."); //�ϴ� ��ȭ �õ� �޽����� ǥ���Ѵ�.
			
	    if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) //���̾Ƹ�� Į�� �����տ� ��� �ִ��� üũ
	   {
	    	//���� ��� �ִٸ� ���� �ܰ��...
	    	int nowent = 0; //���� ��ȭ�ܰ踦 �����س��� ���� ���� ����
	    	//ItemStack dia = new ItemStack(Material.DIAMOND); //
	    	
	        nowent = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
	        player.sendMessage("���� ��ȭ �ܰ�� +" + nowent + "�Դϴ�.");
	        player.sendMessage("��ȭ�� �ʿ��� ���̾ƴ� " + ((nowent + 1) * 2) + "���Դϴ�.");
	        
	        if(player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), ((nowent + 1) * 2)))
	        		{
	        	player.sendMessage("+" + (nowent + 1) + "���� ��ȭ�� �õ��մϴ�.");
	        	player.sendMessage("Ȯ��: " + getpsb(player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL)) + "%");
	        	player.getInventory().removeItem(new ItemStack(Material.DIAMOND, ((nowent + 1) * 2)));
	        	if(getrannum() < getpsb(player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL)))
	        	{
	        		player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (nowent + 1));
	        		//player.updateInventory();
	        		player.sendMessage("��ȭ�� �����ϼ̽��ϴ�!");
	        	}
	        	else{
	        		//player.updateInventory();
	        		player.sendMessage("��ȭ�� �����ϼ̽��ϴ�.");
	        	}
	        		}
	        else {
	        	player.sendMessage("��ȭ �õ��� �ʿ��� ���̾ư� �����մϴ�.");
	        }
	    
	   }
	    else{ //���� ���̾Ƹ�� ���� �����տ� ��� ���� �ʴٸ�...
	    	 player.sendMessage("�տ� ���̾Ƹ�� ���� ��� �ٽ� �õ����ּ���."); //�޽����� �Բ� �Լ� Ż��
	    }
	    
	    }
		
		
	return true;
	}
}