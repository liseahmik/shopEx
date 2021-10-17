package com.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item_img")
@Data
public class ItemImg{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_img_id")
    private Long id;
    private String imgName;
    private String oriImgName; // 원본 이미지 파일명
    private String imgUrl;
    private String repimgYn; // 대표 이미지 여부(Y/N)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
