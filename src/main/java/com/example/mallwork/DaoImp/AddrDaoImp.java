package com.example.mallwork.DaoImp;

import com.example.mallwork.Dao.AddrDao;
import com.example.mallwork.Entity.Address;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository//���ݷ��ʲ�
public  class AddrDaoImp implements AddrDao {
	
	@Autowired
	private QueryRunner queryRunner;
	/**
	 * ��ѯĬ�ϵ�ַ
	 */
	@Override
	public int findDefaultAddrByUserId(Integer userId) {
		//��ѯ
		String sql = "select count(id) as num from action_address where user_id = ? and default_addr=1 and del_state=0";
		try {
			return queryRunner.query(sql,new ColumnListHandler<Long>("num"),userId).get(0).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * ������ַ��Ϣ
	 */
	@Override
	public int instertAddress(Address addr) {
		//�����ջ񷽷�
		String sql = "insert into action_address(user_id,name,phone,mobile,"
				+ "province,city,district,addr,zip,default_addr,created,updated) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {
				addr.getUserId(),addr.getName(),addr.getPhone(),addr.getMobile(),
				addr.getProvince(),addr.getCity(),addr.getDistrict(),addr.getAddr(),
				addr.getZip(),addr.getDefaultAddr(),addr.getCreated(),addr.getUpdated()
		};
		//ִ��
		try {
			return queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * ���µ�ַ��Ϣ
	 */
	@Override
	public int updateAddress(Address addr) {
		String sql = "update action_address set updated = ?";
		List<Object> params = new ArrayList<>();
		params.add(addr.getUpdated());
		//ʹ��java��long�Ĺ������ж�name�Ƿ�Ϊ��
		if (!StringUtils.isEmpty(addr.getName())) {
			sql+=" ,name = ?";
			params.add(addr.getName());
		}
		//ʹ��java��long�Ĺ������ж�phone�Ƿ�Ϊ��
		if (!StringUtils.isEmpty(addr.getPhone())) {
			sql+=" ,phone = ?";
			params.add(addr.getPhone());
		}
		//ʹ��java��long�Ĺ������ж�moblie�Ƿ�Ϊ��
		if (!StringUtils.isEmpty(addr.getMobile())) {
			sql+=" ,mobile = ?";
			params.add(addr.getMobile());
		}
		//ʹ��java��long�Ĺ������ж�province�Ƿ�Ϊ��
		if (!StringUtils.isEmpty(addr.getProvince())) {
			sql+=" ,province = ?";
			params.add(addr.getProvince());
		}
		//ʹ��java��long�Ĺ������ж�city�Ƿ�Ϊ��
		if (!StringUtils.isEmpty(addr.getCity())) {
			sql+=" ,city = ?";
			params.add(addr.getCity());
		}
		//ʹ��java��long�Ĺ������ж�district�Ƿ�Ϊ��
		if(!StringUtils.isEmpty(addr.getDistrict())) {
			sql+=",district = ?";
			params.add(addr.getDistrict());
		}
		//ʹ��java��long�Ĺ������ж�addr�Ƿ�Ϊ��
		if(!StringUtils.isEmpty(addr.getAddr())) {
			sql+=",addr = ?";
			params.add(addr.getAddr());
		}
		//ʹ��java��long�Ĺ������ж�zip�Ƿ�Ϊ��
		if(!StringUtils.isEmpty(addr.getZip())) {
			sql+=",zip = ?";
			params.add(addr.getZip());
		}
		//ʹ��java��long�Ĺ������ж�default_addr�Ƿ�Ϊ��
		if(addr.getDefaultAddr()!=null) {
			sql+=",default_addr = ?";
			params.add(addr.getDefaultAddr());
		}
		//ʹ��java��long�Ĺ������ж�del_state�Ƿ�Ϊ��
		if(addr.getDelState()!=null) {
			sql+=",del_state = ?";
			params.add(addr.getDelState());
		}
		sql+= " where id = ?";
		params.add(addr.getId());
		try {
			return queryRunner.update(sql, params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * ��ѯ�û����е�ַ��Ϣ
	 */
	@Override
	public List<Address> findAddressByUserId(Integer userId) {
		String sql="select id,user_id as userId,name,phone,mobile,province,city,"
				+"district,addr,zip,default_addr as defaultAddr,del_state as delState,created,updated"
				+ " from action_address where user_id  = ? and del_state=0 order by default_addr desc,updated desc";
		try {
			return queryRunner.query(sql, new BeanListHandler<Address>(Address.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * ��ȡĬ�ϵ�ַ
	 */
	@Override
	public Address findDefaultAddr(Integer userId) {
		String sql="select id,user_id as userId,name,phone,mobile,province,city,"
				+"district,addr,zip,default_addr as defaultAddr,del_state as delState,created,updated"
				+ " from action_address where user_id=? and default_addr=1";
		try {
			return queryRunner.query(sql, new BeanHandler<Address>(Address.class),userId);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * �����ջ���id��ѯ��ַ��Ϣ
	 */
	@Override
	public Address findAddressById(Integer addrId) {
		String sql="select id,user_id as userId,name,phone,mobile,province,city,"
				+"district,addr,zip,default_addr as defaultAddr,del_state as delState,created,updated"
				+ " from action_address where id=? and del_state=0";
		try {
			return queryRunner.query(sql, new BeanHandler<Address>(Address.class), addrId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
