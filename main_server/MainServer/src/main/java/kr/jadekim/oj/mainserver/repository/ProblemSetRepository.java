package kr.jadekim.oj.mainserver.repository;

import kr.jadekim.oj.mainserver.entity.ProblemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ohyongtaek on 2016. 1. 19..
 */

public interface ProblemSetRepository extends JpaRepository<ProblemSet,Integer>{

    @Query("select count(p) from ProblemSet ps join ps.problemList p join p.submitUsers u on u.id=:user join u.answers a on a.result.isSuccess=true where ps.id=:problemSet")
    int countByUserSuccess(@Param("problemSet") int problemSet,@Param("user") int user);

    @Query("select count(p) from ProblemSet ps join ps.problemList p on p.problemSet.id=:problemSet join p.submitUsers u on u.id=:user")
    int countAllProblem(@Param("problemSet")int problemSet,@Param("user")int user);

    int countById(int id);
}
