
package com.otrebski.pawel.library.interfaces;

/**
 *
 * @author pawel
 */
public interface RepositoryInterface {
    public EntityInterface create(EntityInterface entity) throws Exception;
    public EntityInterface update(Long id, EntityInterface entity) throws Exception;
    public EntityInterface read(Long id) throws Exception;
    public EntityInterface delete(Long id) throws Exception;
}
