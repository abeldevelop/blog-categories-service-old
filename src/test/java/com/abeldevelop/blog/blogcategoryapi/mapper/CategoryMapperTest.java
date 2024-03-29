package com.abeldevelop.blog.blogcategoryapi.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.abeldevelop.blog.blogcategoryapi.domain.Category;
import com.abeldevelop.blog.blogcategoryapi.entity.CategoryEntity;
import com.abeldevelop.blog.blogcategoryapi.resource.CategoryResponseResource;
import com.abeldevelop.blog.blogcategoryapi.resource.CreateCategoryRequestResource;
import com.abeldevelop.blog.blogcategoryapi.resource.UpdateCategoryRequestResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryMapperTest {

	public CategoryMapper categoryMapper;
	
	@BeforeEach
	public void setUp() {
		categoryMapper = new CategoryMapper();
	}
	
	@Test
	public void mapCreateCategoryRequestResourceTest() {
		
		Category expectedResutl = Category.of("first-category", "First Category");
		
		Category result = categoryMapper.mapResourceToDomain(CreateCategoryRequestResource.builder().name("First Category").build());

		assertThat(result).isEqualToComparingFieldByField(expectedResutl);
	}
	
	@Test
	public void mapUpdateCategoryRequestResourceTest() {
		Category expectedResutl = Category.of("first-category", "First Category");
		
		Category result = categoryMapper.mapResourceToDomain(UpdateCategoryRequestResource.builder().name("First Category").build());

		assertThat(result).isEqualToComparingFieldByField(expectedResutl);
	}
	
	@Test
	public void mapDomainToEntityTest() {
		CategoryEntity expectedResutl = CategoryEntity.builder().code("first-category").name("First Category").build();
		
		CategoryEntity result = categoryMapper.mapDomainToEntity(Category.builder().code("first-category").name("First Category").build());

		assertThat(result).isEqualToComparingFieldByField(expectedResutl);
	}
	
	@Test
	public void mapDomainToResourceTest() {
		CategoryResponseResource expectedResutl = CategoryResponseResource.builder().code("first-category").name("First Category").build();
		
		CategoryResponseResource result = categoryMapper.mapDomainToResource(Category.builder().code("first-category").name("First Category").build());

		assertThat(result).isEqualToComparingFieldByField(expectedResutl);
	}
	
	@Test
	public void mapEntityToDomainTest() {
		Category expectedResutl = Category.of("first-category", "First Category");
		
		Category result = categoryMapper.mapEntityToDomain(CategoryEntity.builder().code("first-category").name("First Category").build());
		
		assertThat(result).isEqualToComparingFieldByField(expectedResutl);
	}
}
