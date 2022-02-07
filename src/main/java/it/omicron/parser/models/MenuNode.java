package it.omicron.parser.models;

import java.util.List;

public class MenuNode {
	private int depth;
	private Integer nodeId; 
	private String nodeName; 
	private String nodeType; 
	private String groupType; 
	private String status;
	private String flowType;
	private Long startValidityTs; 
	private Long endValidityTs; 
	private String tag; 
	private Resource resource; 
	private List<MenuNode> nodes; 
	public MenuNode() { 
		super(); 
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowTrype) {
		this.flowType = flowTrype;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getStartValidityTs() {
		return startValidityTs;
	}
	public void setStartValidityTs(Long startValidityTs) {
		this.startValidityTs = startValidityTs;
	}
	public Long getEndValidityTs() {
		return endValidityTs;
	}
	public void setEndValidityTs(Long endValidityTs) {
		this.endValidityTs = endValidityTs;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public List<MenuNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<MenuNode> nodes) {
		this.nodes = nodes;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	} 




}

