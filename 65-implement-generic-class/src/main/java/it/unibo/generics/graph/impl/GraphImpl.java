package it.unibo.generics.graph.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    final Map<N, HashSet<N>> map = new HashMap<>();

    @Override
    public void addNode(final N node) {
        if(node != null){
            map.putIfAbsent(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(final N source, final N target) {
        if(source != null && target != null){
            if(map.containsKey(source) && map.containsKey(target)){
                map.get(source).add(target);
            }
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(map.keySet());
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        if(node != null){
            if(map.containsKey(node)){
                return new HashSet<>(map.get(node));
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public List getPath(Object source, Object target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}
