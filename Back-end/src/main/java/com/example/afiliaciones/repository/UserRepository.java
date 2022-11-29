package com.example.afiliaciones.repository;

import com.example.afiliaciones.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM READER R WHERE R.CORREO = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM READER R WHERE R.CREADO BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> findByDateCreate(String startDate, String endDate);

    @Query(value = "SELECT * FROM READER R WHERE R.MODIFICADO BETWEEN  ?1 AND ?2", nativeQuery = true)
    List<User> findByDateModify(String startDate, String endDate);

    @Query(value = "SELECT * FROM READER R WHERE R.ULTIMO BETWEEN  ?1 AND ?2", nativeQuery = true)
    List<User> findByDateLastLogin(String startDate, String endDate);

    @Query(value = "SELECT * FROM READER R WHERE R.ACTIVO = ?1", nativeQuery = true)
    List<User> findByActive(String active);

    @Query(value = "SELECT * FROM READER R WHERE R.ID IN (SELECT READER_PHONES.USER_ID FROM READER_PHONES WHERE READER_PHONES.PHONES_ID IN (SELECT PHONES.ID FROM PHONES WHERE PHONES.CODIGO_PAIS=?1) GROUP BY READER_PHONES.USER_ID )", nativeQuery = true)
    List<User> findByContryCode(String code);

    @Query(value = "SELECT * FROM READER R WHERE R.ID IN (SELECT READER_PHONES.USER_ID FROM READER_PHONES WHERE READER_PHONES.PHONES_ID IN (SELECT PHONES.ID FROM PHONES WHERE PHONES.CODIGO_CIUDAD=?1) GROUP BY READER_PHONES.USER_ID )", nativeQuery = true)
    List<User> findByCityCode(String code);

    @Query(value = "SELECT * FROM READER R WHERE R.NOMBRE LIKE %?1%", nativeQuery = true)
    List<User> findByName(String name);

    @Query(value = "SELECT * FROM READER R WHERE R.NOMBRE LIKE %?1% AND R.CORREO LIKE %?2% AND R.CREADO BETWEEN ?3 AND ?4", nativeQuery = true)
    List<User> findByThreeParam(String name, String email,String startDate, String endDate);

}
