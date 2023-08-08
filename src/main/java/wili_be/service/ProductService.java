package wili_be.service;

import org.springframework.web.multipart.MultipartFile;
import wili_be.dto.PostDto;
import wili_be.entity.Member;
import wili_be.entity.Post;

import java.io.IOException;
import java.util.List;

import static wili_be.dto.PostDto.*;

public interface ProductService {
    void addProduct(MultipartFile file, String productInfoJson, String snsId);

    List<String> getImagesKeysByMember(String snsId);

    List<String> getThumbnailImagesKeysByMember(String snsId);

    List<byte[]> getImagesByMember(String snsId) throws IOException;

    byte[] getImageByMember(String imageKey) throws IOException;

    List<PostMainPageResponse> getPostByMember(String snsId);

    PostResponseDto getPostResponseDtoFromId(Long id);
    List<PostMainPageResponse> getPostResponseDtoFromProductName(String productName);

    List<PostMainPageResponse> getPostResponseDtoFromBrandName(String brandName);

    Post getPostFromId(Long id);

    Boolean validateUserFromPostAndSnsId(String snsId, Long postId);

    PostResponseDto updatePost(Long postId, PostUpdateResponseDto postUpdateDto);

    String changePostToJson(PostResponseDto post);

    String changeByteToJson(byte[] bytes);

    List<String> changeBytesToJson(List<byte[]> bytes);

    List<String> changePostDtoToJson(List<PostMainPageResponse> postResponseDtoList);

    List<PostMainPageResponse> randomFeed(Member member);

    void deletePostByPostId(Long PostId);
}
