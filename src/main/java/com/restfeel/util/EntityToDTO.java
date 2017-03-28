package com.restfeel.util;

import java.util.ArrayList;
import java.util.List;

import com.restfeel.dto.AssertionDTO;
import com.restfeel.dto.BaseDTO;
import com.restfeel.dto.BasicAuthDTO;
import com.restfeel.dto.BodyAssertDTO;
import com.restfeel.dto.ColorDTO;
import com.restfeel.dto.ConversationDTO;
import com.restfeel.dto.DigestAuthDTO;
import com.restfeel.dto.FormDataDTO;
import com.restfeel.dto.GenericEntityDTO;
import com.restfeel.dto.GenericEntityDataDTO;
import com.restfeel.dto.GenericEntityFieldDTO;
import com.restfeel.dto.NodeDTO;
import com.restfeel.dto.ProjectDTO;
import com.restfeel.dto.RfHeaderDTO;
import com.restfeel.dto.RfRequestDTO;
import com.restfeel.dto.RfResponseDTO;
import com.restfeel.dto.TagDTO;
import com.restfeel.dto.UrlParamDTO;
import com.restfeel.dto.UserDTO;
import com.restfeel.dto.WorkspaceDTO;
import com.restfeel.entity.Assertion;
import com.restfeel.entity.BaseEntity;
import com.restfeel.entity.BaseNode;
import com.restfeel.entity.BasicAuth;
import com.restfeel.entity.BodyAssert;
import com.restfeel.entity.Color;
import com.restfeel.entity.Conversation;
import com.restfeel.entity.DigestAuth;
import com.restfeel.entity.FormParam;
import com.restfeel.entity.GenericEntity;
import com.restfeel.entity.GenericEntityData;
import com.restfeel.entity.GenericEntityField;
import com.restfeel.entity.NamedEntity;
import com.restfeel.entity.Project;
import com.restfeel.entity.RfHeader;
import com.restfeel.entity.RfRequest;
import com.restfeel.entity.RfResponse;
import com.restfeel.entity.Tag;
import com.restfeel.entity.UrlParam;
import com.restfeel.entity.User;
import com.restfeel.entity.Workspace;

public class EntityToDTO {

    private EntityToDTO() {}

    public static BaseDTO toDTO(BaseEntity entity) {
	if (entity == null)
	    return null;

	BaseDTO dto = new BaseDTO();

	copyBaseData(dto, entity);

	return dto;
    }

    public static BaseDTO toDTO(NamedEntity entity) {
	if (entity == null)
	    return null;

	BaseDTO dto = toDTO(entity);

	copyBaseData(dto, entity);

	return dto;
    }

    public static UserDTO toDTO(User entity) {

	if (entity == null)
	    return null;

	UserDTO dto = new UserDTO();
	dto.setId(entity.getId());
	dto.setName(entity.getName());

	return dto;
    }

    public static ConversationDTO toDTO(Conversation entity) {

	if (entity == null)
	    return null;

	ConversationDTO dto = new ConversationDTO();

	copyBaseData(dto, entity);

	dto.setRfRequestDTO(toDTO(entity.getRfRequest()));
	dto.setRfResponseDTO(toDTO(entity.getRfResponse()));
	dto.setDuration(entity.getDuration());

	return dto;
    }

    public static RfRequestDTO toDTO(RfRequest entity) {

	if (entity == null)
	    return null;

	RfRequestDTO dto = new RfRequestDTO();

	copyBaseData(dto, entity);

	dto.setApiUrl(entity.getApiUrl());
	dto.setEvaluatedApiUrl(entity.getEvaluatedApiUrl());
	dto.setMethodType(entity.getMethodType());
	dto.setApiBody(entity.getApiBody());
	dto.setHeaders(toListOfRfHeaderDTO(entity.getRfHeaders()));
	dto.setUrlParams(toListOfUrlParamDTO(entity.getUrlParams()));
	dto.setFormParams(toListOfFormDataDTO(entity.getFormParams()));
	dto.setBasicAuthDTO(toDTO(entity.getBasicAuth()));
	dto.setDigestAuthDTO(toDTO(entity.getDigestAuth()));
	dto.setAssertionDTO(toDTO(entity.getAssertion()));

	return dto;
    }

    public static AssertionDTO toDTO(Assertion entity) {

	if (entity == null)
	    return null;

	AssertionDTO dto = new AssertionDTO();

	dto.setStatusCode(entity.getStatusCode());
	dto.setResponseSize(entity.getResponseSize());
	dto.setResponseTime(entity.getResponseSize());
	dto.setBodyContentType(entity.getBodyContentType());
	dto.setBodyAssertDTOs(toListOfBodyAssertDTO(entity.getBodyAsserts()));

	return dto;
    }

    public static BodyAssertDTO toDTO(BodyAssert entity) {

	if (entity == null)
	    return null;

	BodyAssertDTO dto = new BodyAssertDTO();

	dto.setPropertyName(entity.getPropertyName());
	dto.setComparator(entity.getComparator());
	dto.setExpectedValue(entity.getExpectedValue());
	dto.setActualValue(entity.getActualValue());
	dto.setSuccess(entity.isSuccess());

	return dto;
    }

    public static RfResponseDTO toDTO(RfResponse entity) {

	if (entity == null)
	    return null;

	RfResponseDTO dto = new RfResponseDTO();

	copyBaseData(dto, entity);

	dto.setBody(entity.getBody());
	dto.setHeaders(toListOfRfHeaderDTO(entity.getRfHeaders()));

	return dto;
    }

    public static BasicAuthDTO toDTO(BasicAuth entity) {
	if (entity == null)
	    return null;

	BasicAuthDTO dto = new BasicAuthDTO();

	dto.setUsername(entity.getUsername());
	dto.setPassword(entity.getPassword());

	return dto;
    }

    public static DigestAuthDTO toDTO(DigestAuth entity) {
	if (entity == null)
	    return null;

	DigestAuthDTO dto = new DigestAuthDTO();

	dto.setUsername(entity.getUsername());
	dto.setPassword(entity.getPassword());

	return dto;
    }

    public static FormDataDTO toDTO(FormParam entity) {
	if (entity == null)
	    return null;

	FormDataDTO dto = new FormDataDTO();
	dto.setKey(entity.getParamKey());
	dto.setValue(entity.getParamValue());

	return dto;
    }

    public static UrlParamDTO toDTO(UrlParam entity) {
	if (entity == null)
	    return null;

	UrlParamDTO dto = new UrlParamDTO();
	dto.setKey(entity.getParamKey());
	dto.setValue(entity.getParamValue());

	return dto;
    }

    public static RfHeaderDTO toDTO(RfHeader entity) {

	if (entity == null)
	    return null;

	RfHeaderDTO dto = new RfHeaderDTO();
	dto.setHeaderName(entity.getHeaderName());
	dto.setHeaderValue(entity.getHeaderValue());

	return dto;
    }

    public static NodeDTO toDTO(BaseNode entity) {

	if (entity == null)
	    return null;

	NodeDTO dto = new NodeDTO();

	copyBaseData(dto, entity);

	dto.setNodeType(entity.getNodeType());
	dto.setParentId(entity.getParentId());
	dto.setProjectId(entity.getProjectId());
	dto.setPosition(entity.getPosition());
	dto.setStarred(entity.getStarred());
	dto.setMethod(entity.getMethod());
	dto.setTags(toListOfTagDTO(entity.getTags()));
	dto.setConversationDTO(toDTO(entity.getConversation()));
	dto.setGenericEntityDTO(toDTO(entity.getGenericEntity()));
	if(entity.getConversation()!=null && entity.getConversation().getRfRequest()!=null){
	    dto.setApiURL(entity.getConversation().getRfRequest().getApiUrl());
	}

	return dto;

    }

    public static GenericEntityDTO toDTO(GenericEntity entity) {

	if (entity == null)
	    return null;

	GenericEntityDTO dto = new GenericEntityDTO();

	copyBaseData(dto, entity);

	dto.setEntityDataList(toListOfGenericEntityDataDTO(entity.getEntityDataList()));
	dto.setFields(toListOfGenericEntityFieldDTO(entity.getFields()));

	return dto;

    }

    public static GenericEntityFieldDTO toDTO(GenericEntityField entity) {

	if (entity == null)
	    return null;

	GenericEntityFieldDTO dto = new GenericEntityFieldDTO();

	dto.setName(entity.getName());
	dto.setType(entity.getType());

	return dto;
    }

    public static GenericEntityDataDTO toDTO(GenericEntityData entity) {

	if (entity == null)
	    return null;

	GenericEntityDataDTO dto = new GenericEntityDataDTO();

	copyBaseData(dto, entity);

	dto.setData(entity.getData());

	return dto;

    }

    public static TagDTO toDTO(Tag entity) {

	if (entity == null)
	    return null;

	TagDTO dto = new TagDTO();

	copyBaseData(dto, entity);

	dto.setColor(toDTO(entity.getColor()));
	dto.setWorkspace(toDTO(entity.getWorkspace()));

	return dto;
    }

    private static ColorDTO toDTO(Color entity) {

	if (entity == null)
	    return null;

	ColorDTO dto = new ColorDTO();

	dto.setDisplayName(entity.getDisplayName());
	dto.setColorCode(entity.getColorCode());

	return dto;
    }

    public static WorkspaceDTO toDTO(Workspace entity) {

	if (entity == null)
	    return null;

	WorkspaceDTO dto = new WorkspaceDTO();

	copyBaseData(dto, entity);

	dto.setProjects(toListOfProjectDTO(entity.getProjects()));

	return dto;
    }

    public static ProjectDTO toDTO(Project entity) {

	if (entity == null)
	    return null;

	ProjectDTO dto = new ProjectDTO();
	dto.setProjectRef(toDTO(entity.getProjectRef()));

	return dto;
    }

    public static List<BodyAssertDTO> toListOfBodyAssertDTO(List<BodyAssert> entity) {

	if (entity == null)
	    return null;

	List<BodyAssertDTO> dto = new ArrayList<BodyAssertDTO>();
	for (BodyAssert item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<GenericEntityFieldDTO> toListOfGenericEntityFieldDTO(List<GenericEntityField> entity) {

	if (entity == null)
	    return null;

	List<GenericEntityFieldDTO> dto = new ArrayList<GenericEntityFieldDTO>();
	for (GenericEntityField item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<GenericEntityDataDTO> toListOfGenericEntityDataDTO(List<GenericEntityData> entity) {

	if (entity == null)
	    return null;

	List<GenericEntityDataDTO> dto = new ArrayList<GenericEntityDataDTO>();
	for (GenericEntityData item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<TagDTO> toListOfTagDTO(List<Tag> entity) {

	if (entity == null)
	    return null;

	List<TagDTO> dto = new ArrayList<TagDTO>();
	for (Tag item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<ProjectDTO> toListOfProjectDTO(List<Project> entity) {

	if (entity == null)
	    return null;

	List<ProjectDTO> dto = new ArrayList<ProjectDTO>();
	for (Project item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<RfHeaderDTO> toListOfRfHeaderDTO(List<RfHeader> entity) {

	if (entity == null)
	    return null;

	List<RfHeaderDTO> dto = new ArrayList<RfHeaderDTO>();
	for (RfHeader item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<UrlParamDTO> toListOfUrlParamDTO(List<UrlParam> entity) {

	if (entity == null)
	    return null;

	List<UrlParamDTO> dto = new ArrayList<UrlParamDTO>();
	for (UrlParam item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    public static List<FormDataDTO> toListOfFormDataDTO(List<FormParam> entity) {

	if (entity == null)
	    return null;

	List<FormDataDTO> dto = new ArrayList<FormDataDTO>();
	for (FormParam item : entity) {
	    dto.add(toDTO(item));
	}

	return dto;
    }

    private static void copyBaseData(BaseDTO dto, BaseEntity entity) {
	dto.setId(entity.getId());
	dto.setCreatedDate(entity.getCreatedDate());
	dto.setCreatedBy(toDTO(entity.getCreatedBy()));
	dto.setLastModifiedDate(entity.getLastModifiedDate());
	dto.setLastModifiedBy(toDTO(entity.getLastModifiedBy()));
	dto.setStatus(entity.getStatus());
    }

    private static void copyBaseData(BaseDTO dto, NamedEntity entity) {

	dto.setId(entity.getId());
	dto.setCreatedDate(entity.getCreatedDate());
	dto.setCreatedBy(toDTO(entity.getCreatedBy()));
	dto.setLastModifiedDate(entity.getLastModifiedDate());
	dto.setLastModifiedBy(toDTO(entity.getLastModifiedBy()));
	dto.setStatus(entity.getStatus());

	dto.setName(entity.getName());
	dto.setDescription(entity.getDescription());
    }

}
