package com.abeldevelop.blog.blogcategoryapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.abeldevelop.blog.blogcategoryapi.component.ErrorMessageProperties;
import com.abeldevelop.blog.blogcategoryapi.util.CategoryApiConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "categories", schema = CategoryApiConstants.DB_SCHEMA)
public class CategoryEntity {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "code", nullable = false, unique = true)
	@Size(min = 3, max = 25, message = ErrorMessageProperties.CATEGORY_CODE_SIZE)
	private String code;
	
	@Column(name = "name", nullable = false, unique = true)
	@Size(min = 3, max = 25, message = ErrorMessageProperties.CATEGORY_NAME_SIZE)
	private String name;
	
}
