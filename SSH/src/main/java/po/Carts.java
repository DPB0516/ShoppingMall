package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Carts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cartid;
	@Column(name="userid")
    private Integer userid;
	@Column(name="goodsid")
    private Integer goodsid;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    @Override
	public String toString() {
		return "Carts [cartid=" + cartid + ", userid=" + userid + ", goodsid="
				+ goodsid + "]";
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}