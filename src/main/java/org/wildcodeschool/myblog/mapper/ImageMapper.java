package org.wildcodeschool.myblog.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wildcodeschool.myblog.dto.ImageDTO;
import org.wildcodeschool.myblog.model.Article;
import org.wildcodeschool.myblog.model.Image;
import org.wildcodeschool.myblog.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageMapper {

    @Autowired
    private ArticleRepository articleRepository;


    public ImageDTO convertToDTO(Image image) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(image.getId());
        imageDTO.setUrl(image.getUrl());
        if (image.getArticles() != null) {
            imageDTO.setArticleIds(image.getArticles().stream().map(Article::getId).collect(Collectors.toList()));
        }
        return imageDTO;
    }


    public Image convertToEntity(ImageDTO imageDTO) {
        Image image = new Image();
        image.setId(imageDTO.getId());
        image.setUrl(imageDTO.getUrl());
        if (imageDTO.getArticleIds() != null) {
            List<Article> articles = articleRepository.findAllById(imageDTO.getArticleIds());
            image.setArticles(articles);
        }
        return image;
    }
}
