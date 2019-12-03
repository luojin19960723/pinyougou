import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class test {
    @Reference
    private SpecificationService specificationService;

    @Test
    public void addEntity(){
        Specification specification=new Specification();
        TbSpecification specification1 = specification.getSpecification();
        specification1.setSpecName("cpu");
        List<TbSpecificationOption> specificationOptions = specification.getSpecificationOptions();
        for(TbSpecificationOption tbSpecificationOption:specificationOptions){
            tbSpecificationOption.setSpecId(specification1.getId());
            tbSpecificationOption.setOrders(1);
            tbSpecificationOption.setId(null);
        }


        try {
            specificationService.addEntityGroup(specification);

            //return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            //return new Result(false, "增加失败");
        }
    }

}
