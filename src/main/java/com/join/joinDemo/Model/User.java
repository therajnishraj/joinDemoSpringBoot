package com.join.joinDemo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_custom")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    @OneToMany(mappedBy = "userObj",cascade=CascadeType.ALL)
    List<Order> orderList;

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
        for (Order order : orderList) {
            order.setUserObj(this); // ✅ Auto-assign user to each order
        }
    }
}
