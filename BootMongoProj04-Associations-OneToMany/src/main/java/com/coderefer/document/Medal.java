package com.coderefer.document;

import com.coderefer.utils.MedalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@Setter
public class Medal {
    @Id
    private String id;
    private MedalType type;
    private String sportName;
    private String eventName;
    private Double prizeMoney;

    public Medal() {
        System.out.println("Medal:: 0-Param Constructor");
    }

    @Override
    public String toString() {
        return "Medal{" +
                "id=" + id +
                ", type=" + type +
                ", prizeMoney='" + prizeMoney + '\'' +
                ", sportName='" + sportName + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
